package model.dao;

import javax.persistence.Query;
import model.domain.Cliente;

/**
 *
 * @author paulo_2
 */
public class ClienteDao extends GenericAbstractCrudDao<Cliente, Integer> {

	@Override
	protected Integer getChave(Cliente cliente) {
		return cliente.getCodigo();
	}

	@Override
	protected String getSqlConsultaGenerica(Cliente cliente) {
		StringBuilder sb = new StringBuilder("from Cliente f where 1 = 1 ");
		if (cliente.getCodigo() != null) {
			sb.append("and f.codigo = :codigo ");
		}
		if (cliente.getNome() != null) {
			sb.append("and upper(f.nome) like upper(:nome) ");
		}
		if (cliente.getPedidos()!= null) {
            sb.append("and f.pedidos = :pedidos ");
        }
       
		

		return sb.toString();
	}

	@Override
	protected Cliente getNovoObjeto() {
		return new Cliente();
	}

	@Override
	protected Query populaParametrosSqlGenerico(Query query,
			Cliente cliente) {
		if (cliente.getCodigo() != null) {
			query.setParameter("codigo", cliente.getCodigo());
		}
		if (cliente.getNome() != null) {
			query.setParameter("nome", "%" + cliente.getNome() + "%");
		}
		if (cliente.getPedidos() != null) {
			query.setParameter("pedido", "%" + cliente.getPedidos() + "%");
		}
		
		
		
		return query;
	}
}
