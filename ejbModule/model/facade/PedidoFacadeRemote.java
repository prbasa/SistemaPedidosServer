package model.facade;

import java.util.List;

import javax.ejb.Remote;

import model.domain.Cliente;
import model.domain.Pedido;

@Remote
public interface PedidoFacadeRemote {

	public static String JNDI_NAME = "SistemaPedidosServer/PedidoFacade!model.facade.PedidoFacadeRemote";
	
	public List<Cliente> pesquisarCliente(Cliente cliente);

	public List<Pedido> pesquisarPedido(Pedido pedido);

	public void salvarPedido(Pedido pedido);

	public void excluirPedido(Pedido pedido);
	
	public List<Pedido> pesquisarTodos();

}