package model.domain;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import util.exception.CrudException;
import util.exception.ValidacaoException;

/**
 *
 * @author paulo_2
 */

@Entity
@Table(name = "TB_PEDIDO")
public class Pedido implements Validavel, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_PEDIDO")
	private Integer codigo;

	@Column(name = "NM_VALOR")
	protected Double valor;

	@Enumerated(EnumType.STRING)
	@Column(name = "STAPED", nullable = false)
	private StatusPedido status = StatusPedido.EMAPROVACAO;

	@Column(name = "NM_APROVADO")
	public boolean aprovado;

	@Column(name = "NM_REPROVADO")
	public boolean reprovado;

	@Column(name = "NM_FINALIZADO")
	public boolean finalizado;

	@ManyToOne
	@JoinColumn(name = "CODCLI", nullable = false)
	private Cliente cliente;

	public Pedido() {

	}
	
	public Pedido(Double valor, StatusPedido status, Cliente cliente) {
        this.valor = valor;
        this.status = status;
        this.cliente = cliente;
    } 

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public boolean isReprovado() {
		return reprovado;
	}

	public void setReprovado(boolean reprovado) {
		this.reprovado = reprovado;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void aprova() throws CrudException {
		setStatus(status.aprova(this));

	}

	public void reprova() throws CrudException {
		setStatus(status.reprova(this));

	}

	public void finaliza() throws CrudException {
		setStatus(status.finaliza(this));

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public void validar() throws ValidacaoException {
		if (this.valor == null || this.valor.equals("")) {
			throw new ValidacaoException("Falha na validação:"
					+ "O campo valor é obrigatório");
		}
		if (this.cliente == null) {
	            throw new ValidacaoException("Falha na validação:"
	                    + "é necessário selecionar um cliente");
	    }

	}

}
