package fachada2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import Modelo2.Endereco;
import Modelo2.Pedido;
import Modelo2.Usuario;
import dao2.DAO;
import dao2.DAOPedido;
import dao2.DAOUsuario;




public class Fachada2 {
	private static DAOUsuario daousuario = new DAOUsuario();  
	private static DAOPedido daopedido = new DAOPedido();  
	private static Usuario logado;
	public static Integer codigoPedido = 0;

	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}
	
	
	///localiza a pessoa no repositorio, a torna pessoa logada e retorna esta pessoa
	public static Usuario login(String email, String senha) throws  Exception {
		
		
		if(logado!=null) {
			
			throw new Exception("ja existe um usuario logado:"+logado.getEmail());
		}

		Usuario usu = daousuario.readlogin(email, senha);
		if(usu==null) {
			throw new Exception("email ou senha invalida:");
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
			throw new Exception("cadastrar pessoa - pessoa com cpf j� cadastrado:" + nome);
		}
		
		//Formatando string para data
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(datanasc, format);
		
		u = new Usuario(nome,cpf,localDate,email,senha);
		daousuario.create(u);	
		DAO.commit();
		return u;
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
	
	
	// S� PRA TESTE -- EXCLUI DEPOIS
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
	
	
	//ALTERANDO DADOS USUARIO N�O LOGADO
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
	
	
	// LISTANDO USUARIOS
		// Tinha dado erro
	public static String listarUsuarios(){
		List<Usuario> usuarios= daousuario.readAll();
		String texto="-----------listagem de Pessoas-----------\n";
		
		if(usuarios == null) {
			System.out.println("sem listar");
		}
		
		for (Usuario u : usuarios) {
			texto += u + "\n";
//			texto += "nome = " + u.getNomeUsuario() + "," + " " + "email = " + u.getEmail() +
//				"," + " " + "cpf = " + u.getCpf() + "," + " " + "Senha=" + u.getSenha() + "\n";
		}
		
		return texto;
	}
	
	
	//REALIZANDO PEDIDO
		// Falta O codigoPedido pra concertar
	public static Pedido realizarPedido(String uf,String cidade, String bairro, String rua, String numero ) throws  Exception{
		
		DAO.begin();
		if(logado==null) {					
			throw new Exception("Precisa fazer login");
		};
		
		codigoPedido++;
		System.out.println(codigoPedido);
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
	
	
	//EXCLUIR TELEFONE 
	public static Pedido excluirPedidoPessoa(Integer numero) 
			throws  Exception{
		DAO.begin();
		
		if(logado==null) {	
			DAO.rollback();
			throw new Exception("Precisa fazer login");
		};
		
		//N�O est� localizando
//		String num = Integer.toString(numero);
//		Pedido t = daopedido.read(num);
//		System.out.println(t);
//		if(t == null) {
//			DAO.rollback();
//			throw new Exception("excluir Pedido - Pedido n�o cadastrado:" + logado.getNomeUsuario());
//		}
//		
		
		Pedido t = logado.localizar(numero);	//localiza dentro do objeto
		if(t == null) {
			DAO.rollback();
			throw new Exception("excluir pedido - pessoa nao possui este pedido:" + logado.getNomeUsuario());
		}
		
		logado.remover(t);
		daousuario.update(logado);	
		daopedido.delete(t);	//excluir telefone orfao
		DAO.commit();
		return t;
	}
	
	
	//APAGAR TODOS OS PEDIDOS
//	public static void removerPedidos(Usuario u) throws  Exception{
//		if(logado==null) {					
//			throw new Exception("Precisa fazer login");
//		};
//		
//		for(Pedido p : u.getPedidos()) {
//			u.remover(p);
//			daopedido.delete(p);		//deletar telefone orfao do banco
//			
//		}
//	}

}
