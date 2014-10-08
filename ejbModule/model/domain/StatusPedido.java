package model.domain;

import java.io.Serializable;

import util.exception.CrudException;

public enum StatusPedido implements EstadoPedido, Serializable {
	EMAPROVACAO(new EmAprovacao()), APROVADO(new Aprovado()), REPROVADO(
			new Reprovado()), FINALIZADO(new Finalizado());

	private final EstadoPedido estadoPedido;

	StatusPedido(EstadoPedido estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	@Override
	public StatusPedido aprova(Pedido pedido) throws CrudException {
		// TODO Auto-generated method stub
		return estadoPedido.aprova(pedido);

	}

	@Override
	public StatusPedido reprova(Pedido pedido) throws CrudException {
		// TODO Auto-generated method stub
		return estadoPedido.reprova(pedido);

	}

	@Override
	public StatusPedido finaliza(Pedido pedido) throws CrudException {
		// TODO Auto-generated method stub
		return estadoPedido.finaliza(pedido);

	}

}
