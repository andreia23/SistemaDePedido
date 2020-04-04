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
			

			//TESTAR ALTERAR DADOS
//			System.out.println("alterando...");
//			Fachada2.alterarDadosLogado("Mael","mael@IFPB","2222");
			
			
			//TESTAR LOGIN
			u = Fachada2.login("luci@ifpb", "5050");
			System.out.println("pessoa logada =>" + Fachada2.getLogado().getNomeUsuario());

			
			//TESTAR LOGOFF
//			Fachada2.logoff();
//			System.out.println("Logoff feito com sucesso"); 
			
			
			//TESTAR REALIZAR PEDIDO
//			Fachada2.realizarPedido("PB","Conde","Centro","Epitacio", "08");
//			System.out.println("pedido feito com sucesso=>" + Fachada2.getLogado().getPedidos());
			
						
			//TESTAR REMOVER PEDIDO CODIGO
			Fachada2.excluirPedidoPessoa(8);
			
		
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

