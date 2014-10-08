package model.facade.impl;

import model.dao.FornecedorDao;
import model.dao.GenericAbstractCrudDao;
import model.domain.Fornecedor;
import model.facade.FornecedorFacadeRemote;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class FornecedorFacade
 */
@Stateless
public class FornecedorFacade implements FornecedorFacadeRemote {
	
	@PersistenceContext
	private EntityManager entityManager;

	private final GenericAbstractCrudDao<Fornecedor,Integer> fornecedorDao;

	public FornecedorFacade() {
		fornecedorDao = new FornecedorDao();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Fornecedor> pesquisarFornecedor(Fornecedor fornecedor) {
		return fornecedorDao.pesquisar(fornecedor,entityManager);
	}

	@Override
	public void salvarFornecedor(Fornecedor fornecedor) {
		fornecedorDao.salvar(fornecedor,entityManager);
	}

	@Override
	public void excluirFornecedor(Fornecedor fornecedor) {
		fornecedorDao.excluir(fornecedor,entityManager);
	}


}
