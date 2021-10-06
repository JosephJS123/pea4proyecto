package com.compras.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compras.api.entidad.Movimiento;

public interface MovimientoServicio extends JpaRepository<Movimiento, Long>{

}