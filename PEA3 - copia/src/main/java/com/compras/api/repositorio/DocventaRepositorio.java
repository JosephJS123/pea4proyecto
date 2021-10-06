package com.compras.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compras.api.entidad.Docventa;

public interface DocventaRepositorio extends JpaRepository<Docventa, Long>{

}
