package com.sugarDreams.service.impl;

import com.sugarDreams.dao.ComentariosDao;

import com.sugarDreams.domain.Comentarios;
import com.sugarDreams.domain.Usuario;
import com.sugarDreams.service.ComentariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentariosServiceImpl implements ComentariosService {

    @Autowired
    private ComentariosDao comentariosDao;

    @Transactional(readOnly = true)
    @Override
    public List<Comentarios> getComentarioss(boolean activo) {
        var lista = comentariosDao.findAll();
        return lista;
    }

    @Transactional(readOnly = true)
    @Override
    public Comentarios getComentarios(Comentarios comentarios) {
        return comentariosDao.findById(comentarios.getUsuario().getIdUsuario()).orElse(null);
    }

    @Transactional
    @Override
    public void save(Comentarios comentarios) {
        comentariosDao.save(comentarios);
    }

}
