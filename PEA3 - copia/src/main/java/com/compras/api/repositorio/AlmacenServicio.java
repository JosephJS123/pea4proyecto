package com.compras.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compras.api.entidad.Almacen;

public interface AlmacenServicio extends JpaRepository<Almacen, Long> {

}
