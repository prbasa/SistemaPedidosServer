package model.facade;

import java.util.List;

import javax.ejb.Remote;

import model.domain.Fornecedor;

@Remote
public interface FornecedorFacadeRemote {

	public static String JNDI_NAME = "SistemaPedidosServer/FornecedorFacade!model.facade.FornecedorFacadeRemote";

	public List<Fornecedor> pesquisarFornecedor(Fornecedor fornecedor);

	public void salvarFornecedor(Fornecedor fornecedor);

	public void excluirFornecedor(Fornecedor fornecedor);

}