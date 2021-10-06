package com.compras.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compras.api.entidad.Empleado;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long>{

}
