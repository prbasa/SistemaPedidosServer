package model.domain;

/**
 *
 * @author paulo_2
 */
public class Icms implements Calculavel {

	@Override
	public Double calcular(NotaFiscal notaFiscal) {
		return (notaFiscal.getValorTotal() * 17 / 100);

	}

}
