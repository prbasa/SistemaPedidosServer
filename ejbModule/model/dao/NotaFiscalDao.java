package model.dao;

import javax.persistence.Query;
import model.domain.NotaFiscal;

/**
 *
 * @author paulo_2
 */
public class NotaFiscalDao extends GenericAbstractCrudDao<NotaFiscal, Integer> {

	@Override
	protected Integer getChave(NotaFiscal notaFiscal) {
		return notaFiscal.getCodigo();
	}

	@Override
	protected String getSqlConsultaGenerica(NotaFiscal notaFiscal) {
		StringBuilder sb = new StringBuilder("from NotaFiscal f where 1 = 1 ");
		if (notaFiscal.getCodigo() != null) {
			sb.append("and f.codigo = :codigo ");
		}

		if (notaFiscal.getValorTotal() != null) {
			sb.append("and f.valorTotal = :valorTotal ");
		}

		if (notaFiscal.getIcmsCalculado() != null) {
			sb.append("and f.icmsCalculado = :icmsCalculado ");
		}

		if (notaFiscal.getPisCalculado() != null) {
			sb.append("and f.pisCalculado = :pisCalculado ");
		}

		if (notaFiscal.getCofinsCalculado() != null) {
			sb.append("and f.cofinsCalculado = :cofinsCalculado ");
		}

		if (notaFiscal.getIpiCalculado() != null) {
			sb.append("and f.ipiCalculado = :ipiCalculado ");
		}

		if (notaFiscal.getIqqiCalculado() != null) {
			sb.append("and f.iqqiCalculado = :iqqiCalculado ");
		}

		if (notaFiscal.getIqqiiCalculado() != null) {
			sb.append("and f.iqqiiCalculado = :iqqiiCalculado ");
		}

		return sb.toString();
	}

	@Override
	protected NotaFiscal getNovoObjeto() {
		return new NotaFiscal();
	}

	@Override
	protected Query populaParametrosSqlGenerico(Query query,
			NotaFiscal notaFiscal) {
		if (notaFiscal.getCodigo() != null) {
			query.setParameter("codigo", notaFiscal.getCodigo());
		}
		if (notaFiscal.getValorTotal() != null) {
			query.setParameter("valorTotal", notaFiscal.getValorTotal());
		}
		if (notaFiscal.getIcmsCalculado() != null) {
			query.setParameter("icmsCalculado", notaFiscal.getIcmsCalculado());
		}
		if (notaFiscal.getPisCalculado() != null) {
			query.setParameter("pisCalculado", notaFiscal.getPisCalculado());
		}
		if (notaFiscal.getCofinsCalculado() != null) {
			query.setParameter("cofinsCalculado",
					notaFiscal.getCofinsCalculado());
		}
		if (notaFiscal.getIpiCalculado() != null) {
			query.setParameter("ipiCalculado", notaFiscal.getIpiCalculado());
		}
		if (notaFiscal.getIqqiCalculado() != null) {
			query.setParameter("iqqiCalculado", notaFiscal.getIqqiCalculado());
		}
		if (notaFiscal.getIqqiiCalculado() != null) {
			query.setParameter("iqqiiCalculado", notaFiscal.getIqqiiCalculado());
		}

		return query;
	}

}
