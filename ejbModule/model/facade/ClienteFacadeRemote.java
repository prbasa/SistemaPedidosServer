package model.facade;

import java.util.List;

import javax.ejb.Remote;

import model.domain.Cliente;
import model.domain.NotaFiscal;
import model.domain.Pedido;

@Remote
public interface ClienteFacadeRemote {

	public static String JNDI_NAME = "SistemaPedidosServer/ClienteFacade!model.facade.ClienteFacadeRemote";
	
	public List<Pedido> pesquisarPedido(Pedido pedido);
	
    public List<Cliente> pesquisarCliente(Cliente cliente);

	public void salvarCliente(Cliente cliente);

	public void excluirCliente(Cliente cliente);

}