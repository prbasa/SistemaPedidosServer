package model.domain;

/**
 *
 * @author paulo_2
 */
public class Cofins implements Calculavel {

	@Override
	public Double calcular(NotaFiscal notaFiscal) {
		return (notaFiscal.getValorTotal() * (7.6 / 100));
	}

}
