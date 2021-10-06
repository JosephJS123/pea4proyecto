package com.compras.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compras.api.entidad.Kardex;

public interface KardexServicio extends JpaRepository<Kardex, Long> {

}