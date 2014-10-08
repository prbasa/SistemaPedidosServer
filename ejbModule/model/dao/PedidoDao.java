package model.dao;

import javax.persistence.Query;

import model.domain.Pedido;

/**
 *
 * @author paulo_2
 */
public class PedidoDao extends GenericAbstractCrudDao<Pedido, Integer> {

	@Override
	protected Integer getChave(Pedido pedido) {
		return pedido.getCodigo();
	}

	@Override
	protected String getSqlConsultaGenerica(Pedido pedido) {
		StringBuilder sb = new StringBuilder("from Pedido f where 1 = 1");
		if (pedido.getCodigo() != null) {
			sb.append("and f.codigo = :codigo ");
		}
		if (pedido.getStatus()!= null) {
			sb.append("and f.status = :status ");
		}
		if (pedido.getValor() != null) {
			sb.append("and f.valor = :valor");
		}
		
		if (pedido.getCliente() != null) {
	            sb.append("and f.cliente = :cliente ");
	    }
		

		return sb.toString();
		
		
	}

	@Override
	protected Pedido getNovoObjeto() {
		return new Pedido();
	}

	@Override
	protected Query populaParametrosSqlGenerico(Query query, Pedido pedido) {
		if (pedido.getCodigo() != null) {
			query.setParameter("codigo", pedido.getCodigo());
		}

		if (pedido.getStatus()!= null) {
			query.setParameter("status", pedido.getStatus());
		}

		if (pedido.getValor() != null) {
			query.setParameter("valor", pedido.getValor());
		}
		
		if (pedido.getCliente() != null) {
			query.setParameter("cliente", pedido.getCliente());
		}
		
		

		return query;
	}

}
