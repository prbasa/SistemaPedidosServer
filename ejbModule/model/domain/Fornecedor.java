package model.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import util.exception.ValidacaoException;

/**
 *
 * @author paulo_2
 */
@Entity
@Table(name = "TB_FORNECEDOR")
public class Fornecedor implements Validavel, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_FORNECEDOR")
	private Integer codigo;

	@Column(name = "NM_FORNECEDOR")
	private String nome;

	@Column(name = "DS_CPFCNPJ")
	private String cpfCnpj;

	@Column(name = "JURIDICA")
	private boolean cnpj;

	public Fornecedor() {
	}

	public Fornecedor(Integer codigo, String nome, String cpfCnpj, boolean cnpj) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.cnpj = cnpj;
		setCnpj(cpfCnpj.contains("/"));
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public boolean isCnpj() {
		return cnpj;
	}

	public void setCnpj(boolean cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 53 * hash + Objects.hashCode(this.codigo);
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
		final Fornecedor other = (Fornecedor) obj;
		if (!Objects.equals(this.codigo, other.codigo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public void validar() throws ValidacaoException {
		 if (this.nome == null || this.nome.equals("")) {
	            throw new ValidacaoException("Falha na validação:"
	                    + "O campo nome é obrigatório");
	     }
		 if (this.cpfCnpj == null || this.cpfCnpj.equals("")) {
	            throw new ValidacaoException("Falha na validação:"
	                    + "O campo cpf/cnpj é obrigatório");
	     }
		
	}

}
