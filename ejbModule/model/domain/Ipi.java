package model.domain;

/**
 *
 * @author paulo_2
 */
public class Ipi implements Calculavel {

	@Override
	public Double calcular(NotaFiscal notaFiscal) {
		return (notaFiscal.getValorTotal() * 5 / 100);
	}

}
