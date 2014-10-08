package model.domain;

/**
 *
 * @author paulo_2
 */
public class Pis implements Calculavel {

	@Override
	public Double calcular(NotaFiscal notaFiscal) {
		return (notaFiscal.getValorTotal() * (1.65 / 100));
	}

}
