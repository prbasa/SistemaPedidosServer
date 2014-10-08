package model.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import util.exception.ValidacaoException;

/**
 *
 * @author paulo_2
 */
@Entity
@Table(name = "TB_NOTAFISCAL")
public class NotaFiscal implements Validavel, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_NOTAFISCAL")
	private Integer codigo;

	@Column(name = "NM_VALORTOTALNF")
	private Double valorTotal;

	@Column(name = "NM_ICMSNF")
	private Double icmsCalculado;

	@Column(name = "NM_PISNF")
	private Double pisCalculado;

	@Column(name = "NM_COFINSNF")
	private Double cofinsCalculado;

	@Column(name = "NM_IPINF")
	private Double ipiCalculado;

	@Column(name = "NM_IQQI")
	private Double iqqiCalculado;

	@Column(name = "NM_IQQII")
	private Double iqqiiCalculado;

	@Transient
	private boolean Icms;

	@Transient
	private boolean Pis;

	@Transient
	private boolean Cofins;

	@Transient
	private boolean Ipi;

	@Transient
	private boolean Iqqi;

	@Transient
	private boolean Iqqii;

	public NotaFiscal() {

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 59 * hash + Objects.hashCode(this.codigo);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final NotaFiscal other = (NotaFiscal) obj;
		if (!Objects.equals(this.codigo, other.codigo)) {
			return false;
		}
		return true;
	}

	public Double getIcmsCalculado() {
		return icmsCalculado;
	}

	public void setIcmsCalculado(Double icmsCalculado) {
		this.icmsCalculado = icmsCalculado;
	}

	public Double getPisCalculado() {
		return pisCalculado;
	}

	public void setPisCalculado(Double pisCalculado) {
		this.pisCalculado = pisCalculado;
	}

	public Double getCofinsCalculado() {
		return cofinsCalculado;
	}

	public void setCofinsCalculado(Double cofinsCalculado) {
		this.cofinsCalculado = cofinsCalculado;
	}

	public Double getIpiCalculado() {
		return ipiCalculado;
	}

	public void setIpiCalculado(Double ipiCalculado) {
		this.ipiCalculado = ipiCalculado;
	}

	public boolean isIcms() {
		return Icms;
	}

	public void setIcms(boolean Icms) {
		this.Icms = Icms;
	}

	public boolean isPis() {
		return Pis;
	}

	public void setPis(boolean Pis) {
		this.Pis = Pis;
	}

	public boolean isCofins() {
		return Cofins;
	}

	public void setCofins(boolean Cofins) {
		this.Cofins = Cofins;
	}

	public boolean isIpi() {
		return Ipi;
	}

	public void setIpi(boolean Ipi) {
		this.Ipi = Ipi;
	}

	public Double getIqqiCalculado() {
		return iqqiCalculado;
	}

	public void setIqqiCalculado(Double iqqiCalculado) {
		this.iqqiCalculado = iqqiCalculado;
	}

	public Double getIqqiiCalculado() {
		return iqqiiCalculado;
	}

	public void setIqqiiCalculado(Double iqqiiCalculado) {
		this.iqqiiCalculado = iqqiiCalculado;
	}

	public boolean isIqqi() {
		return Iqqi;
	}

	public void setIqqi(boolean Iqqi) {
		this.Iqqi = Iqqi;
	}

	public boolean isIqqii() {
		return Iqqii;
	}

	public void setIqqii(boolean Iqqii) {
		this.Iqqii = Iqqii;
	}

	@Override
	public String toString() {
		return "NotaFiscal{" + "codigo=" + codigo + ", valorTotal="
				+ valorTotal + ", Icms=" + Icms + ", Pis=" + Pis + ", Cofins="
				+ Cofins + ", Ipi=" + Ipi + '}';
	}

	@Override
	public void validar() throws ValidacaoException {
		if (this.valorTotal == null || this.valorTotal.equals("")) {
			throw new ValidacaoException("Falha na validação:"
					+ "O campo valor é obrigatório");
		}

	}

}
