package aplicacao_console2;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada2.Fachada2;


public class Consultar {
 
	public Consultar(){
		Fachada2.inicializar();
		try {
			
			System.out.println(Fachada2.consultarUsuarioPorParteNome("lu") );
			System.out.println(Fachada2.consultarPessoasNPedidos(5) );
			System.out.println(Fachada2.consultarPedidosPorNome("luci") );
			System.out.println(Fachada2.consultarPedidoPorProduto("Arroz") );
			System.out.println(Fachada2.consultartotalDeUsuarios());
			System.out.println(Fachada2.consultartotalDePedidos());
			System.out.println(Fachada2.consultartotalDeItens());
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada2.finalizar();
		System.out.println("\nfim do programa");
	}



	//=================================================
	public static void main(String[] args) {
		new Consultar();
	}
}

