package com.sugarDreams.service;

import com.sugarDreams.domain.Pedido;
import com.sugarDreams.domain.Usuario;
import java.util.List;

public interface PedidoService {

    public List<Pedido> getPedidos();

    public Pedido getIdQueque(Pedido pedido);

    public void save(Pedido pedido);

    public void delete(Pedido pedido);

    public List<Pedido> usuario(Usuario usuario);

}
