package com.compras.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compras.api.entidad.Deuda;

public interface DeudaRepositorio extends JpaRepository<Deuda, Long>{

}
