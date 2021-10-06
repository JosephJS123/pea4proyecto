package com.compras.api.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="almacen")
public class Almacen implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idalmacen;
	private String nomalmacen;
	private String descripcion;
	
	public Integer getIdalmacen() {
		return idalmacen;
	}
	public void setIdalmacen(Integer idalmacen) {
		this.idalmacen = idalmacen;
	}
	public String getNomalmacen() {
		return nomalmacen;
	}
	public void setNomalmacen(String nomalmacen) {
		this.nomalmacen = nomalmacen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
