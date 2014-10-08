package model.domain;

/**
 *
 * @author paulo_2
 */
public abstract class TMethodImpCondicional implements Calculavel {

	@Override
	public Double calcular(NotaFiscal notaFiscal) {
		if (usarMaiorImposto(notaFiscal)) {
			return maiorImposto(notaFiscal);
		} else {
			return menorImposto(notaFiscal);
		}

	}

	public abstract boolean usarMaiorImposto(NotaFiscal notaFiscal);

	public abstract Double maiorImposto(NotaFiscal notaFiscal);

	public abstract Double menorImposto(NotaFiscal notaFiscal);

}
