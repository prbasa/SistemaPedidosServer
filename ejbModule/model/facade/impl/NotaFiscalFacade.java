package model.facade.impl;

import model.dao.NotaFiscalDao;
import model.dao.GenericAbstractCrudDao;
import model.domain.NotaFiscal;
import model.facade.NotaFiscalFacadeRemote;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class NotaFiscalFacade
 */
@Stateless
public class NotaFiscalFacade implements NotaFiscalFacadeRemote {

	@PersistenceContext
	private EntityManager entityManager;
	
	private final GenericAbstractCrudDao<NotaFiscal, Integer> notaFiscalDao;

	public NotaFiscalFacade() {
		notaFiscalDao = new NotaFiscalDao();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<NotaFiscal> pesquisarNotaFiscal(NotaFiscal notaFiscal) {
		return notaFiscalDao.pesquisar(notaFiscal, entityManager);
	}

	@Override
	public void salvarNotaFiscal(NotaFiscal notaFiscal) {
		notaFiscalDao.salvar(notaFiscal, entityManager);
	}

	@Override
	public void excluirNotaFiscal(NotaFiscal notaFiscal) {
		notaFiscalDao.excluir(notaFiscal, entityManager);
	}

}
