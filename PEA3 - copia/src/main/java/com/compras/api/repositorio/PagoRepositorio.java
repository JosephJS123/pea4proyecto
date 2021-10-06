package com.compras.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compras.api.entidad.Pago;

public interface PagoRepositorio extends JpaRepository<Pago, Long>{

}
