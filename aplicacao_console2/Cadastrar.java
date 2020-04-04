package aplicacao_console2;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import Modelo2.Usuario;
import fachada2.Fachada2;



public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada2.inicializar();
			Usuario u;
			
			System.out.println("cadastrando...");
			u =Fachada2.cadastrarUsuario("Tom Souza","9090","29/05/1990","tom@ifpb","8787");
			System.out.println(u);
			
		
		
		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		
	
		
		
		
		finally {
			Fachada2.finalizar();
		}

		System.out.println("fim do programa");
	}


	public void cadastrar(){

	}	


	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


