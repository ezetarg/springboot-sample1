package com.demo.sample1.api.presentation;

import com.demo.sample1.domain.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoForm {
    private Integer idPedido;
    private String nombre;
    private Double monto;
    private Double descuento;

    public Pedido asPedido() {
        return Pedido.builder()
                .idPedido(idPedido)
                .nombre(nombre)
                .monto(monto)
                .descuento(descuento)
                .build();
    }
}
