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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import util.exception.ValidacaoException;

/**
 *
 * @author paulo_2
 */
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente implements Validavel, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_CLIENTE")
	private Integer codigo;

	@Column(name = "NM_CLIENTE")
	private String nome;

	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;

	public Cliente() {
	}

	public Cliente(Integer codigo, String nome, Pedido pedido,
			NotaFiscal notaFiscal) {
		this.codigo = codigo;
		this.nome = nome;
		this.pedidos.add(pedido);
		

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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
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
		final Cliente other = (Cliente) obj;
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

	}

}
