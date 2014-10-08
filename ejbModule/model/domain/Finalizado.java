package model.domain;

import util.exception.CrudException;

/**
 *
 * @author paulo_2
 */
public class Finalizado implements EstadoPedido {
	
	@Override
	public StatusPedido aprova(Pedido pedido) throws CrudException {
		throw new CrudException("Pedidos já finalizado !");
	}

	@Override
	public StatusPedido reprova(Pedido pedido) throws CrudException {
		throw new CrudException("Pedidos já finalizado !");
	}

	@Override
	public StatusPedido finaliza(Pedido pedido) throws CrudException {
		throw new CrudException("Pedidos já finalizado !");
	}

	
	
	

}
