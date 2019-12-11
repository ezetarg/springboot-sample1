package com.demo.sample1.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {
    private @Id @GeneratedValue Integer idPedido;
    private @NotBlank @Size(max = 100) String nombre;
    private @NotNull Integer monto;
    private Integer descuento;
}
