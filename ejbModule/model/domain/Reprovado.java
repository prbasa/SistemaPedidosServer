package model.domain;

import util.exception.CrudException;

/**
 *
 * @author paulo_2
 */
public class Reprovado implements EstadoPedido {

	@Override
	public StatusPedido aprova(Pedido pedido) throws CrudException {
		throw new CrudException(
				"Pedidos reprovados não podem ser aprovados !");
	}

	@Override
	public StatusPedido reprova(Pedido pedido) throws CrudException {
		throw new CrudException("Pedido já está reprovado !");
	}

	@Override
	public StatusPedido finaliza(Pedido pedido) {
		return StatusPedido.FINALIZADO;
	}

}
