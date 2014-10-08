package model.domain;

import javax.ejb.CreateException;

import util.exception.CrudException;

/**
 *
 * @author paulo_2
 */
public class Aprovado implements EstadoPedido {

	@Override
	public StatusPedido aprova(Pedido pedido) throws CrudException {
		throw new CrudException("Pedido já está aprovado");
	}

	@Override
	public StatusPedido reprova(Pedido pedido)throws CrudException {
		throw new RuntimeException("Pedidos aprovados não podem ser reprovados");
	}

	@Override
	public StatusPedido finaliza(Pedido pedido) {
		return StatusPedido.FINALIZADO;
	}

}
