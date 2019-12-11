package com.demo.sample1.api;

import com.demo.sample1.api.presentation.PedidoForm;
import com.demo.sample1.domain.Pedido;
import com.demo.sample1.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class PedidoController {
    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<Pedido> save(@RequestBody PedidoForm pedidoForm) {
        pedidoService.insertOrUpdate(pedidoForm.asPedido());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<Pedido> find(@PathVariable Integer idPedido) {
        Pedido pedido = pedidoService.select(idPedido);

        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idPedido}")
    public void delete(@PathVariable Integer idPedido) {
        pedidoService.delete(idPedido);
    }
}
