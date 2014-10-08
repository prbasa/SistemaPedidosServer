package model.domain;

import util.exception.CrudException;

/**
 *
 * @author paulo_2
 */
public interface EstadoPedido {
	public StatusPedido aprova(Pedido pedido)throws CrudException;

	public StatusPedido reprova(Pedido pedido)throws CrudException;

	public StatusPedido finaliza(Pedido pedido)throws CrudException;

}
