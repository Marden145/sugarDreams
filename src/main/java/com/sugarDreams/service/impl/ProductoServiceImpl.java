package com.sugarDreams.service.impl;

import com.sugarDreams.dao.ProductoDao;
import com.sugarDreams.domain.Producto;
import com.sugarDreams.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activo) {
        var lista = productoDao.findAll();

        if (activo) {// solo activos
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)

    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Transactional
    @Override
    public void save(Producto producto) {
        productoDao.save(producto);

    }

    @Transactional
    @Override
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> nombre(String nombre) {
        return productoDao.findByNombreContainingIgnoringCase(nombre);
    }
}
