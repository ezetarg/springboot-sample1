package com.demo.sample1.repository;

import com.demo.sample1.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosDAO extends JpaRepository<Pedido, Integer> {
}
