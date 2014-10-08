package model.facade;

import java.util.List;

import javax.ejb.Remote;

import model.domain.NotaFiscal;

@Remote
public interface NotaFiscalFacadeRemote {

	public static String JNDI_NAME = "SistemaPedidosServer/NotaFiscalFacade!model.facade.NotaFiscalFacadeRemote";

	public List<NotaFiscal> pesquisarNotaFiscal(NotaFiscal notaFiscal);

	public void salvarNotaFiscal(NotaFiscal notaFiscal);

	public void excluirNotaFiscal(NotaFiscal notaFiscal);

}