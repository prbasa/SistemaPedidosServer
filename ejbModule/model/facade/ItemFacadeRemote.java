package model.facade;

import java.util.List;

import javax.ejb.Remote;

import model.domain.Item;

@Remote
public interface ItemFacadeRemote {

	public static String JNDI_NAME = "SistemaPedidosServer/ItemFacade!model.facade.ItemFacadeRemote";

	public List<Item> pesquisarItem(Item item);

	public void salvarItem(Item item);

	public void excluirItem(Item item);

}