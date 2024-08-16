package com.sugarDreams.service.impl;

import com.sugarDreams.dao.CategoriaDao;
import com.sugarDreams.domain.Categoria;
import com.sugarDreams.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activo) {
        var lista = categoriaDao.findAll();

        if (activo) {// solo activos
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)

    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Transactional
    @Override
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);

    }

    @Transactional
    @Override
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

}
