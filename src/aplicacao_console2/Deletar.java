package aplicacao_console2;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import Modelo2.Usuario;
import fachada2.Fachada2;


public class Deletar {

	public Deletar(){
		Fachada2.inicializar();
		Usuario u = null;
		try {
			
			System.out.println("deletando...");
			Fachada2.excluirUsuario("1212");
			Fachada2.excluirPedidoPessoa(2);
			Fachada2.excluirItemPedido(2);
			
			
			System.out.println("deletado");
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada2.finalizar();
		System.out.println("fim do programa");
	}

	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}

