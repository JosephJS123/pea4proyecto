package com.compras.api.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="deuda")
public class Deuda implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long iddeuda;
	private Double monto;
	private Integer estado;
	
	@ManyToOne
	@JoinColumn(name = "iddocventa")
	private Docventa docventa;

	public Long getIddeuda() {
		return iddeuda;
	}

	public void setIddeuda(Long iddeuda) {
		this.iddeuda = iddeuda;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Docventa getDocventa() {
		return docventa;
	}

	public void setDocventa(Docventa docventa) {
		this.docventa = docventa;
	}
	
	
}
