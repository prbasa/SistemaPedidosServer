package model.facade.impl;

import model.dao.ClienteDao;
import model.dao.PedidoDao;
import model.dao.GenericAbstractCrudDao;
import model.domain.Cliente;
import model.domain.Pedido;
import model.facade.PedidoFacadeRemote;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class PedidoFacade
 */
@Stateless
public class PedidoFacade implements PedidoFacadeRemote {

	@PersistenceContext
	private EntityManager entityManager;
	
	private final GenericAbstractCrudDao<Cliente, Integer> clienteDao;

	private final GenericAbstractCrudDao<Pedido, Integer> pedidoDao;

	public PedidoFacade() {
		pedidoDao = new PedidoDao();
		clienteDao = new ClienteDao();
	}

	@Override
	public List<Pedido> pesquisarPedido(Pedido pedido) {
		return pedidoDao.pesquisar(pedido, entityManager);
	}

	@Override
	public void salvarPedido(Pedido pedido) {
		pedidoDao.salvar(pedido, entityManager);
	}

	@Override
	public void excluirPedido(Pedido pedido) {
		pedidoDao.excluir(pedido, entityManager);
	}

	@Override
	public List<Pedido> pesquisarTodos() {
		// TODO Auto-generated method stub
		return pedidoDao.pesquisarTodos(entityManager);
		
	}

	@Override
	public List<Cliente> pesquisarCliente(Cliente cliente) {
		return clienteDao.pesquisar(cliente,entityManager);
	}

}
