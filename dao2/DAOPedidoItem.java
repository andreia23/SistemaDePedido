/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package dao2;


import java.util.List;

import com.db4o.query.Query;

import Modelo2.PedidoItem;


public class DAOPedidoItem extends DAO<PedidoItem>{
	//numero é campo único 
	public PedidoItem read (Object chave) {
		Integer codi = (Integer) chave;
		
		Query q = manager.query();
		q.constrain(PedidoItem.class);
		q.descend("codPedidoItem").constrain(codi);
		List<PedidoItem> resultados = q.execute();
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
	public List<PedidoItem> consultarTelefonesPorPrefixo(String prefixo) {
		Query q = manager.query();
		q.constrain(PedidoItem.class);
		q.descend("numero").constrain(prefixo).startsWith(true);
		//q.descend("pessoa").descend("nome").orderDescending();
		List<PedidoItem> result = q.execute(); 
		return result;
	}

	public List<PedidoItem> consultarTelefonesPorNome(String nome) {
		Query q = manager.query();
		q.constrain(PedidoItem.class);
		q.descend("pessoa").descend("nome").constrain(nome);
		List<PedidoItem> result = q.execute(); 
		return result;
	}


}
