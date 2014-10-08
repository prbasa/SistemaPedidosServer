package model.domain;

/**
 *
 * @author paulo_2
 */
public class Iqqi extends TMethodImpCondicional {
	@Override
	public boolean usarMaiorImposto(NotaFiscal notaFiscal) {
		return (notaFiscal.getValorTotal() > 700);
	}

	@Override
	public Double maiorImposto(NotaFiscal notaFiscal) {
		return (notaFiscal.getValorTotal() * 2 / 100);
	}

	@Override
	public Double menorImposto(NotaFiscal notaFiscal) {
		return (notaFiscal.getValorTotal() * 1 / 100);
	}

}
