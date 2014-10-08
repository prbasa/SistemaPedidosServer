package model.dao;

import javax.persistence.Query;
import model.domain.Fornecedor;

/**
 *
 * @author paulo_2
 */
public class FornecedorDao extends GenericAbstractCrudDao<Fornecedor, Integer> {

	@Override
	protected Integer getChave(Fornecedor fornecedor) {
		return fornecedor.getCodigo();
	}

	@Override
	protected String getSqlConsultaGenerica(Fornecedor fornecedor) {
		StringBuilder sb = new StringBuilder("from Fornecedor f where 1 = 1 ");
		if (fornecedor.getCodigo() != null) {
			sb.append("and f.codigo = :codigo ");
		}
		if (fornecedor.getNome() != null) {
			sb.append("and upper(f.nome) like upper(:nome) ");
		}
		if (fornecedor.getCpfCnpj() != null) {
			sb.append("and upper(f.cpfCnpj) like upper(:cpfCnpj) ");
		}

		return sb.toString();
	}

	@Override
	protected Fornecedor getNovoObjeto() {
		return new Fornecedor();
	}

	@Override
	protected Query populaParametrosSqlGenerico(Query query,
			Fornecedor fornecedor) {
		if (fornecedor.getCodigo() != null) {
			query.setParameter("codigo", fornecedor.getCodigo());
		}
		if (fornecedor.getNome() != null) {
			query.setParameter("nome", "%" + fornecedor.getNome() + "%");
		}
		if (fornecedor.getCpfCnpj() != null) {
			query.setParameter("cpfCnpj", "%" + fornecedor.getCpfCnpj() + "%");
		}
		return query;
	}
}
