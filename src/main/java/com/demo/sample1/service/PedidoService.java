package com.demo.sample1.service;

import com.demo.sample1.domain.Pedido;
import com.demo.sample1.repository.BumexMemcached;
import com.demo.sample1.repository.PedidosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {
    private PedidosDAO pedidosDAO;
    private BumexMemcached bumexMemcached;

    @Autowired
    public PedidoService(PedidosDAO pedidosDAO, BumexMemcached bumexMemcached) {
        this.pedidosDAO = pedidosDAO;
        this.bumexMemcached = bumexMemcached;
    }

    public void insertOrUpdate(Pedido pedido) {
        Pedido pedidoSaved = pedidosDAO.save(pedido);

        bumexMemcached.set(pedido.getIdPedido().toString(), pedidoSaved);
    }

    public void delete(Integer idPedido) {
        pedidosDAO.deleteById(idPedido);
        bumexMemcached.delete(idPedido.toString());
    }

    public Pedido select(Integer idPedido) {
        Object cachedObject = bumexMemcached.get(idPedido.toString());

        if (cachedObject != null) {
            return (Pedido) cachedObject;
        }

        Optional<Pedido> optionalPedido = pedidosDAO.findById(idPedido);

        if (optionalPedido.isPresent()) {
            Pedido pedido = optionalPedido.get();
            bumexMemcached.set(idPedido.toString(), pedido);
            return pedido;
        }

        return null;
    }
}
