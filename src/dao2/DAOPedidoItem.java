/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package dao2;


import java.util.List;

import com.db4o.query.Query;

import Modelo2.Pedido;
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
	public int consultarTotalItens() {
		Query q = manager.query();
		q.constrain(PedidoItem.class);
		int total = q.execute().size(); 
		return total;
	}



}
