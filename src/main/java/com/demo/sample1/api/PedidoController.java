package com.demo.sample1.api;

import com.demo.sample1.api.presentation.PedidoForm;
import com.demo.sample1.domain.Pedido;
import com.demo.sample1.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<Pedido> save(@RequestBody PedidoForm pedidoForm) {
        pedidoService.insertOrUpdate(pedidoForm.asPedido());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<Pedido> find(@PathVariable Integer idPedido) {
        Pedido pedido = pedidoService.select(idPedido);

        if (pedido != null) {
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idPedido}")
    public void delete(@PathVariable Integer idPedido) {
        pedidoService.delete(idPedido);
    }
}
