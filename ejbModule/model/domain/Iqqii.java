package model.domain;

/**
 *
 * @author paulo_2
 */
public class Iqqii extends TMethodImpCondicional {

	@Override
	public boolean usarMaiorImposto(NotaFiscal notaFiscal) {
		return notaFiscal.getValorTotal() > 250;

	}

	@Override
	public Double maiorImposto(NotaFiscal notaFiscal) {
		return notaFiscal.getValorTotal() * 4 / 100;
	}

	@Override
	public Double menorImposto(NotaFiscal notaFiscal) {
		return notaFiscal.getValorTotal() * 3 / 100;
	}

}
