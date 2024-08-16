package com.sugarDreams.service.impl;

import com.sugarDreams.dao.FavoritoDao;
import com.sugarDreams.domain.Favorito;
import com.sugarDreams.domain.Usuario;
import com.sugarDreams.service.FavoritoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FavoritoServiceImpl implements FavoritoService {

    @Autowired
    private FavoritoDao favoritoDao;

    @Transactional(readOnly = true)
    @Override
    public List<Favorito> getFavoritos(Favorito favorito) {
        var lista = favoritoDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Favorito getFavorito(Favorito favorito) {
        return favoritoDao.findById(favorito.getIdFavorito()).orElse(null);
    }

    @Transactional
    @Override
    public void save(Favorito favorito) {
        favoritoDao.save(favorito);

    }

    @Transactional
    @Override
    public void delete(Favorito favorito) {
        favoritoDao.delete(favorito);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Favorito> usuario(Usuario usuario) {
        return favoritoDao.findByUsuario(usuario);
    }

}
