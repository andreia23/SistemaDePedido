package dao2;

import java.util.List;
import com.db4o.query.Query;


import Modelo2.Usuario;


public class DAOUsuario extends DAO<Usuario> {

	public Usuario readlogin (Object chave,Object chave1) {
		String email = (String) chave;//casting para o tipo da chave
		String senha = (String) chave1;
		
		Query q = manager.query();
		q.constrain(Usuario.class);
		q.descend("email").constrain(email);
		q.descend("senha").constrain(senha);
		List<Usuario> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else 
			return null;
	}

	//cpf é campo unico
	public Usuario read (Object chave) {
		String cpf = (String) chave;	//casting para o tipo da chave
		
		Query q = manager.query();
		q.constrain(Usuario.class);
		q.descend("cpf").constrain(cpf);
		List<Usuario> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	
}

	
//@SuppressWarnings("serial")
//class Filtro  implements Evaluation {
//	private int n;
//	public Filtro (int n) {this.n=n;}
//	public void evaluate(Candidate candidate) {
//		Usuario p = (Usuario) candidate.getObject();
//		candidate.include( p.getPedidos().size()==n);
//	}
//}
//	private boolean compara(Pessoa p, int n) {
//		return p.getTelefones().size()==n;
//	}

