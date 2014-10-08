package model.facade.impl;

import model.dao.ItemDao;
import model.dao.GenericAbstractCrudDao;
import model.domain.Item;
import model.facade.ItemFacadeRemote;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ItemFacade
 */
@Stateless
public class ItemFacade implements ItemFacadeRemote {

	@PersistenceContext
	private EntityManager entityManager;

	private final GenericAbstractCrudDao<Item, Integer> itemDao;

	public ItemFacade() {
		itemDao = new ItemDao();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Item> pesquisarItem(Item item) {
		return itemDao.pesquisar(item, entityManager);
	}

	@Override
	public void salvarItem(Item item) {
		itemDao.salvar(item, entityManager);
	}

	@Override
	public void excluirItem(Item item) {
		itemDao.excluir(item, entityManager);
	}

}
