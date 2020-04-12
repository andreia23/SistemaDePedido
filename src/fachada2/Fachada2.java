package fachada2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import Modelo2.Endereco;
import Modelo2.Pedido;
import Modelo2.PedidoItem;
import Modelo2.Produto;
import Modelo2.Usuario;
import dao2.DAO;
import dao2.DAOPedido;
import dao2.DAOPedidoItem;
import dao2.DAOUsuario;





public class Fachada2 {
	private static DAOUsuario daousuario = new DAOUsuario();  
	private static DAOPedido daopedido = new DAOPedido(); 
	private static DAOPedidoItem daopedidoitem = new DAOPedidoItem();
	private static Usuario logado;
	public static Integer codigoPedido = 0;
	public static Integer codPedidoIntem = 0;

	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}
	
	
	/**********************************************************
	 * USUARIO 
	 **********************************************************/
	
	///localiza a pessoa no repositorio, a torna pessoa logada e retorna esta pessoa
	public static Usuario login(String email, String senha) throws  Exception {
			
		if(logado!=null) {	
			throw new Exception("ja existe um usuario logado:"+logado.getEmail());
		}

		
		Usuario usu = daousuario.readlogin(email, senha);
		if(usu==null) {
			throw new Exception("email ou senha invalida:");
		}
		
		List<Pedido> pedidos = daopedido.readAll();
		for (Pedido p : pedidos) {
			if(usu.getCpf() == p.getUsuario().getCpf()) {
				codigoPedido = p.getCodigoPedido();
			}
		}
		logado = usu;
		return usu;
		
	}
	
	
	//descarta a pessoa logada
	public static void logoff() throws  Exception {
		
		if(logado==null){
			throw new Exception("nao existe um usuario logado:");
		}

		logado = null; 
	}

	
	// retorna a pessoa  logada
	public static Usuario getLogado() {
		return logado;
	}
	
	
	// CADASTRANDO USUARIO
	public static Usuario cadastrarUsuario( String nome,String cpf,String datanasc, String email, String senha) throws  Exception{
		DAO.begin();
		Usuario u = daousuario.read(cpf);
		
		if(u != null) {
			DAO.rollback();
			throw new Exception("cadastrar pessoa - pessoa com cpf já cadastrado:" + nome);
		}
		
		//Formatando string para data
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(datanasc, format);
		
		u = new Usuario(nome,cpf,localDate,email,senha);
		daousuario.create(u);	
		DAO.commit();
		return u;
	}
		
	
	// LISTANDO USUARIOS
		// Tinha dado erro
	public static String listarUsuarios(){
		List<Usuario> usuarios= daousuario.readAll();
		String texto="-----------listagem de Pessoas-----------\n";

		for (Usuario u : usuarios) {
			texto += u + "\n";
//			texto += "nome = " + u.getNomeUsuario() + "," + " " + "email = " + u.getEmail() +
//				"," + " " + "cpf = " + u.getCpf() + "," + " " + "Senha=" + u.getSenha() + "\n";
		}
		return texto;
	}
	
	
    //EXCLUINDO USUARIO
	public static void excluirUsuario(String cpf) throws Exception {
		DAO.begin();
		Usuario u= daousuario.read(cpf);
		
		if (u==null) {
			DAO.rollback();
			throw new Exception("excluir pessoa - cpf inexistente:" + cpf);
		}
		
		System.out.println("deletando o usuario:" + u.getNomeUsuario());
		daousuario.delete(u);  //cascata
		DAO.commit();
	}
	
	
	// SÓ PRA TESTE -- EXCLUI DEPOIS
	public static void excluirVarios(String cpf) throws Exception {
		DAO.begin();
		List<Usuario> usuarios= daousuario.readAll();
		
		for (Usuario u : usuarios) {
			if(u.getCpf() == null) {
				DAO.rollback();
				daousuario.delete(u);  //cascata
				DAO.commit();
			}
		}
	}
	
	
	//ALTERANDO DADOS USUARIO NÃO LOGADO
	public static void alterarDadosNaoLogado(String cpf,String novonome, String novoemail, String novasenha) throws Exception{
		DAO.begin();		
		Usuario us = daousuario.read(cpf);
		
		if (us==null) {
			DAO.rollback();
			throw new Exception("alterar dados - cpf inexistente:" + cpf);
		}
		
		us.setNomeUsuario(novonome);
		us.setEmail(novoemail);
		us.setSenha(novasenha);
		us=daousuario.update(us);     	
		DAO.commit();	
	}
	
	
	//ALTERANDO DADOS USUARIO LOGADO
	public static void alterarDadosLogado(String novonome, String novoemail, String novasenha) throws Exception{
		DAO.begin();		
			
		if(logado==null) {					
			throw new Exception("Precisa fazer login");
		};

		logado.setNomeUsuario(novonome);
		logado.setEmail(novoemail);
		logado.setSenha(novasenha);
		logado=daousuario.update(logado);     	
		DAO.commit();	
	}

	
	/**********************************************************
	 * PEDIDO 
	 **********************************************************/
	
	//REALIZANDO PEDIDO
		// Falta O codigoPedido pra concertar
	public static Pedido realizarPedido(String uf,String cidade, String bairro, String rua, String numero ) throws  Exception{
		
		DAO.begin();
		if(logado==null) {					
			throw new Exception("Precisa fazer login");
		};
		
		codigoPedido ++;
		Endereco end = new Endereco(uf, cidade,bairro, rua, numero);
		Pedido p = new Pedido(codigoPedido,getLogado(),end);
		logado.adicionar(p);
		daousuario.update(logado);
		daopedido.create(p);
		DAO.commit();
		return p;
	}
	
	
	// LISTAR PEDIDOS
	public static String listarPedidos() { 	
		List<Pedido> aux = daopedido.readAll();
		String texto="-----------listagem de Pedidos---------\n";
		for(Pedido t: aux) {
			texto += "\n" + t; 
		}
		return texto;
	}
	
	
	//LISTA OS PEDIDOS POR USUARIO
	public static String listarMeusPedidos()throws  Exception {

		if(logado==null) {					
			throw new Exception("Precisa fazer login");
		};

		Usuario us = daousuario.read(logado.getCpf());
		if(us.getPedidos().isEmpty()){
			throw new Exception("Nenhum pedido realizado");
		}
		
		String texto = "PEDIDOS:" + "\n" ;
		for(Pedido p : us.getPedidos())
			texto+= p + "\n";
		
		
		return texto;
	}
	
	//EXCLUIR PEDIDO 
	public static Pedido excluirPedidoPessoa(Integer codigo) throws  Exception{
		DAO.begin();
		
		if(logado==null) {	
			DAO.rollback();
			throw new Exception("Precisa fazer login");
		};
		
		Pedido t = daopedido.read(codigo);
		if(t == null) {
			DAO.rollback();
			throw new Exception("excluir Pedido - Pedido não cadastrado");
		}
				
		t = logado.localizar(codigo);	//localiza dentro do objeto
		if(t == null) {
			DAO.rollback();
			throw new Exception("excluir pedido - pessoa nao possui este pedido:" + logado.getPedidos());
		}
		
		logado.remover(t);
		daousuario.update(logado);	
		daopedido.delete(t);	//excluir telefone orfao
		DAO.commit();
		return t;
	}
	
	
	//ALTERAR DADOS DO PEDIDO
	public static void alterarPedido(Integer codigo,String novobairro, String novarua, String novonumero  ) throws Exception{
		DAO.begin();
		
		if(logado==null) {	
			DAO.rollback();
			throw new Exception("Precisa fazer login");
		};
		
		Pedido t = daopedido.read(codigo);	
		if (t==null) {
			DAO.rollback();
			throw new Exception("alterar pedido - pedido inexistente:" + codigo);
		}
		
		Endereco novoend = new Endereco(t.getEnderecoEntrega().getUf(),t.getEnderecoEntrega().getCidade(),novobairro,novarua,novonumero); 
		t.setEnderecoEntrega(novoend); 			
		t = daopedido.update(t);     	
		DAO.commit();	
	}
	
	
	/**********************************************************
	 * PEDIDO ITENS 
	 **********************************************************/
	
	//SELECIONA ITENS
	//Problema com o codigo
	public static PedidoItem selecionarItens(String nomeProduto,Integer quantidade) throws  Exception{
		DAO.begin();
		
		if(logado==null) {	
			DAO.rollback();
			throw new Exception("Precisa fazer login");
		};
		
		Pedido pe = daopedido.read(codigoPedido);
		System.out.println(pe);
		if(pe == null) {
			DAO.rollback();
			throw new Exception("adicionar Item - Pedido nao cadastrado:");
		}
				
		codPedidoIntem++;
		Produto pro = new Produto(nomeProduto);
		PedidoItem i = new PedidoItem(codPedidoIntem,pe,quantidade,pro);
		pe.adicionar(i);
		daopedido.update(pe);
		DAO.commit();
		return i;
	}
	
	
	//LISTAR TODOS OS ITENS
	public static String listarItens() { 	
		List<PedidoItem> aux = daopedidoitem.readAll();
		String texto="-----------listagem de Pedidos---------\n";
		for(PedidoItem t: aux) {
			texto += "\n" + t; 
		}
		return texto;
	}
	
	
	//LISTAR ITENS POR CODIGO DE PEDIDO
		//Problema com o codigo do console
	public static String listasMeusItens()throws  Exception {

		if(logado==null) {	
			DAO.rollback();
			throw new Exception("Precisa fazer login");
		};
		
		Pedido pe = daopedido.read(codigoPedido);
		if(pe.getItens().isEmpty()){
			throw new Exception("Nenhum item adicionado");
		}
		
		String texto = "ITENS:" + "\n" ;
		for(PedidoItem p : pe.getItens())
			texto+= p + "\n";

		return texto;
	}
	
	
	//EXCLUIR ITEM
		//Problema com o codigo no console
	public static PedidoItem excluirItemPedido(Integer codigoItem) throws  Exception{
		DAO.begin();
		
		Pedido ped = daopedido.read(codigoPedido);
		
		PedidoItem pi = daopedidoitem.read(codigoItem);
		if(pi == null) {
			DAO.rollback();
			throw new Exception("excluir item - Item não cadastrado:");
		}
				
		pi = ped.localizar(codigoItem);	//localiza dentro do objeto
		if(pi == null) {
			DAO.rollback();
			throw new Exception("excluir item - pedido nao possui este item:" + ped.getItens());
		}
		
		ped.remover(pi);
		daopedido.update(ped);	
		daopedidoitem.delete(pi);	//excluir pedido orfao
		DAO.commit();
		return pi;
	}
	
	
	//ALTERAR DADOS DO ITEM
	public static void alterarItem(Integer codigoItem, String novoProduto, Integer novaquantidade  ) throws Exception{
		DAO.begin();
	
		PedidoItem pi = daopedidoitem.read(codigoItem);	
		if (pi==null) {
			DAO.rollback();
			throw new Exception("alterar item - Item inexistente:" );
		}
			
		Produto pro = new Produto(novoProduto);
		pi.setProduto(pro);
		pi.setQuantidadeItem(novaquantidade);
		pi = daopedidoitem.update(pi);     	
		DAO.commit();	
	}
	

		/**********************************************************
		 * 
		 * CONSULTAS 
		 * 
		 **********************************************************/

		public static String consultarUsuarioPorParteNome(String caracteres) {
			List<Usuario> result = daousuario.consultarUsuariosPorParteNome(caracteres);

			String texto = "\nCONSULTAR USUARIOS POR PARTE DO NOME:"+caracteres.toUpperCase();
			if (result.isEmpty())  
				texto += "consulta vazia";
			else 
				for(Usuario p: result)texto += "\n" + p;
			return texto;
		}
		

		public static String consultarPessoasNPedidos(int n) {
			List<Usuario> result = daousuario.consultarPessoasNPedidos(n);

			String texto = "\nCONSULTAR USUARIOS COM "+n+" PEDIDOS:";
			if (result.isEmpty())  
				texto += "consulta vazia";
			else 
				for(Usuario p: result)texto += "\n" + p;
			return texto;
		}
		

		public static String consultarPedidosPorNome(String n) {
			List<Pedido> result = daopedido.consultarPedidosPorNome(n);
			String texto = "\nCONSULTAR PEDIDOS DE " + n.toUpperCase() + ":";
			if (result.isEmpty())  
				texto += "consulta vazia";
			else 
				for(Pedido t: result)texto += "\n" + t;
			return texto;
		}

		public static String consultarPedidoPorProduto(String n) {
			List<Pedido> result = daopedido.consultarPedidoPorProduto(n);
			String texto = "\nCONSULTAR PEDIDOS COM O PRODUTO " + n.toUpperCase() + ":";
			if (result.isEmpty())  
				texto += "consulta vazia";
			else 
				for(Pedido t: result)texto += "\n" + t;
			return texto;
		}
		

		public static String consultartotalDeUsuarios() {
			int usuarios = daousuario.consultarTotalUsuarios();
			return "\nTOTAL DE USUARIOS: " + usuarios;
			
		}
		
		public static String consultartotalDePedidos() {
			int pedidos = daopedido.consultarTotalPedidos();
			return "TOTAL DE PEDIDOS: " + pedidos;
			
		}
		
		public static String consultartotalDeItens() {
			int itens = daopedidoitem.consultarTotalItens();
			return "TOTAL DE ITENS: " + itens;
			
		}



}

	
	
	

