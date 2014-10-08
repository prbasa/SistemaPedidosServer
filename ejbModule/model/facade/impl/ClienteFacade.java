package model.facade.impl;

import model.dao.ClienteDao;
import model.dao.GenericAbstractCrudDao;
import model.dao.NotaFiscalDao;
import model.dao.PedidoDao;
import model.domain.Cliente;
import model.domain.NotaFiscal;
import model.domain.Pedido;
import model.facade.ClienteFacadeRemote;
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
public class ClienteFacade implements ClienteFacadeRemote {
	
	@PersistenceContext
	private EntityManager entityManager;

	private final GenericAbstractCrudDao<Cliente,Integer> clienteDao;
	
	private final GenericAbstractCrudDao<Pedido,Integer> pedidoDao;

	

	public ClienteFacade() {
		clienteDao = new ClienteDao();
		pedidoDao = new PedidoDao();
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Cliente> pesquisarCliente(Cliente cliente) {
		return clienteDao.pesquisar(cliente,entityManager);
	}

	@Override
	public void salvarCliente(Cliente cliente) {
		clienteDao.salvar(cliente,entityManager);
	}

	@Override
	public void excluirCliente(Cliente cliente) {
		clienteDao.excluir(cliente,entityManager);
	}

	@Override
	public List<Pedido> pesquisarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		return pedidoDao.pesquisar(pedido,entityManager);
	}

	

}
