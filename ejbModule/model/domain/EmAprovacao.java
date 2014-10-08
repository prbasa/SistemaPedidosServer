package model.domain;

import util.exception.CrudException;

/**
 *
 * @author paulo_2
 */
public class EmAprovacao implements EstadoPedido {

	@Override
	public StatusPedido aprova(Pedido pedido) {
		return StatusPedido.APROVADO;
	}

	@Override
	public StatusPedido reprova(Pedido pedido) {
		return StatusPedido.REPROVADO;
	}

	@Override
	public StatusPedido finaliza(Pedido pedido) throws CrudException {
		throw new CrudException(
				"Pedidos em aprovação não podem ir para o Estado finalizado.");
	}

}
