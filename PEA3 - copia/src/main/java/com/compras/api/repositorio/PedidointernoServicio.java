package com.compras.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.compras.api.entidad.Pedidointerno;

public interface PedidointernoServicio extends JpaRepository<Pedidointerno, Long> {

}
