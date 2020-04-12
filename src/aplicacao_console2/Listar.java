package aplicacao_console2;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada2.Fachada2;


public class Listar {

	public Listar(){
		Fachada2.inicializar();
		try {
			System.out.println(Fachada2.listarUsuarios());
			System.out.println(Fachada2.listarPedidos());
			System.out.println(Fachada2.listarItens());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada2.finalizar();
		System.out.println("fim do programa");
	}

	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}

