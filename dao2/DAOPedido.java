/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package dao2;


import java.util.List;

import com.db4o.query.Query;

import Modelo2.Pedido;

 
public class DAOPedido  extends DAO<Pedido>{
	//numero é campo único 
	public Pedido read (Object chave) {
		String codigoPedido = (String) chave;
		
		
		Query q = manager.query();
		q.constrain(Pedido.class);
		q.descend("codigoPedido").constrain(codigoPedido);
		List<Pedido> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	
	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DE TELEFONE
	 * 
	 **********************************************************/
	public List<Pedido> consultarTelefonesPorPrefixo(String prefixo) {
		Query q = manager.query();
		q.constrain(Pedido.class);
		q.descend("numero").constrain(prefixo).startsWith(true);
		//q.descend("pessoa").descend("nome").orderDescending();
		List<Pedido> result = q.execute(); 
		return result;
	}

	public List<Pedido> consultarPedidosPorNome(String nome) {
		Query q = manager.query();
		q.constrain(Pedido.class);
		q.descend("usuario").descend("nomeLogin").constrain(nome);
		List<Pedido> result = q.execute(); 
		return result;
	}



}
