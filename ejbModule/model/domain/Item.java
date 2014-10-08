package model.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import util.exception.ValidacaoException;

/**
 *
 * @author paulo_2
 */
@Entity
@Table(name = "TB_ITEM")
public class Item implements Validavel, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_ITEM")
	private Integer codigo;

	@Column(name = "NM_DESCRICAO")
	private String descricao;

	@Column(name = "NM_VALOR")
	private Double valor;

	@Column(name = "NM_ATIVO")
	private String ativo;

	public Item() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 37 * hash + Objects.hashCode(this.codigo);
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
		final Item other = (Item) obj;
		if (!Objects.equals(this.codigo, other.codigo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Item{" + "codigo=" + codigo + ", descricao=" + descricao
				+ ", valor=" + valor + ", ativo=" + ativo + '}';
	}

	@Override
	public void validar() throws ValidacaoException {
		if (this.descricao == null || this.descricao.equals("")) {
            throw new ValidacaoException("Falha na validação:"
                    + "O campo descrição é obrigatório");
        }
        if (this.valor == null || this.valor.equals("")) {
            throw new ValidacaoException("Falha na validação:"
                    + "O campo valor e obrigatório");
        }
		
	}

}
