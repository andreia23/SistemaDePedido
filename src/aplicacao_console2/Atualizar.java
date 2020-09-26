package aplicacao_console2;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */




import Modelo2.Usuario;
import fachada2.Fachada2;


public class Atualizar {

	public Atualizar(){
		Fachada2.inicializar();
		Usuario u;
		try {
			
		
			//TESTAR LOGIN
			u = Fachada2.login("mael@IFPB", "2222");
			System.out.println("pessoa logada =>" + Fachada2.getLogado());
			
			//TESTAR ALTERAR DADOS DO USUARIO
			System.out.println("alterando...");
			Fachada2.alterarDadosLogado("Mael","mael@IFPB","2222");
			
			//TESTAR REALIZAR PEDIDO
			Fachada2.realizarPedido("PB","Lucena","Vale","Josefa","23");
			System.out.println("pedido feito com sucesso=>" + Fachada2.getLogado().getPedidos());
			

			//TESTAR ALTERAR DADOS DO PEDIDO
			Fachada2.alterarPedido(10, "Jaguaribe", " Carmem","56");
			
			//TESTAR ADICIONAR ITENS
			Fachada2.selecionarItens("Frango",6);
			
			
			//TESTAR LISTAR PEDIDO POR USUARIO
			System.out.println(Fachada2.listarMeusPedidos());
			
			
			//TESTAR LISTAR ITENS POR PEDIDO
			System.out.println(Fachada2.listasMeusItens());
			
			
			//TESTAR APAGAR ITEM CODIGO
			Fachada2.excluirItemPedido(1);
			
			
			//TESTAR ALTERAR DADOS DO ITEM
			Fachada2.alterarItem(5,"Pipos", 2);
			
			//TESTAR LOGOFF
			Fachada2.logoff();
			System.out.println("Logoff feito com sucesso");
			
		
		}
		catch (Exception e) { 
			System.out.println(e.getMessage());
		}
		
		Fachada2.finalizar();
		System.out.println("fim do programa");
	}



	//=================================================
	public static void main(String[] args) {
		new Atualizar();
	}
}

