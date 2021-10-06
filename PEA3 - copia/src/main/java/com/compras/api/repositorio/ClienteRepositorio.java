package com.compras.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compras.api.entidad.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{

}
