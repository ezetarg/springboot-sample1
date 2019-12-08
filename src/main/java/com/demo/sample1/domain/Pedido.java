package com.demo.sample1.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {
    private @Id @GeneratedValue Integer idPedido;
    private String nombre;
    private Double monto;
    private Double descuento;
}
