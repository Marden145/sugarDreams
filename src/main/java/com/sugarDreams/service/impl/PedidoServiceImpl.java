package com.sugarDreams.service.impl;

import com.sugarDreams.dao.PedidoDao;
import com.sugarDreams.domain.Pedido;
import com.sugarDreams.service.PedidoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sugarDreams.domain.Usuario;


@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoDao pedidoDao;

    @Transactional(readOnly = true)
    @Override
    public List<Pedido> getPedidos() {
        var lista = pedidoDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Pedido getIdQueque(Pedido pedido) {
        return pedidoDao.findById(pedido.getIdQueque()).orElse(null);
    }

    @Transactional
    @Override
    public void save(Pedido pedido) {
        pedidoDao.save(pedido);

    }

    @Transactional
    @Override
    public void delete(Pedido pedido) {
        pedidoDao.delete(pedido);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> usuario(Usuario usuario) {
        return pedidoDao.findByUsuario(usuario);
    }

}
