package com.compras.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compras.api.entidad.Inventario;

public interface InventarioServicio extends JpaRepository<Inventario, Long> {

}