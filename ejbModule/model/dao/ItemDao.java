/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import javax.persistence.Query;

import model.domain.Item;

/**
 *
 * @author paulo_2
 */
public class ItemDao extends GenericAbstractCrudDao<Item, Integer> {

	@Override
	protected Integer getChave(Item item) {
		return item.getCodigo();
	}

	@Override
	protected String getSqlConsultaGenerica(Item item) {
		StringBuilder sb = new StringBuilder("from Item f where 1 = 1 ");
		if (item.getCodigo() != null) {
			sb.append("and f.codigo = :codigo ");
		}
		if (item.getDescricao() != null) {
			sb.append("and upper(f.descricao) like upper(:descricao) ");
		}
		if (item.getValor() != null) {
			sb.append("and f.valor = :valor ");
		}

		if (item.getAtivo() != null) {
			sb.append("and upper(f.ativo) like upper(:ativo) ");
		}

		return sb.toString();
	}

	@Override
	protected Item getNovoObjeto() {
		return new Item();
	}

	@Override
	protected Query populaParametrosSqlGenerico(Query query, Item item) {
		if (item.getCodigo() != null) {
			query.setParameter("codigo", item.getCodigo());
		}
		if (item.getDescricao() != null) {
			query.setParameter("descricao", "%" + item.getDescricao() + "%");
		}
		if (item.getValor() != null) {
			query.setParameter("valor", item.getValor());
		}

		if (item.getAtivo() != null) {
			query.setParameter("ativo", "%" + item.getAtivo() + "%");
		}
		return query;
	}
}
