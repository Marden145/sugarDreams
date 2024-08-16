package com.sugarDreams.service.impl;

import com.sugarDreams.dao.InscripcionDao;
import com.sugarDreams.domain.Inscripcion;
import com.sugarDreams.domain.Usuario;
import com.sugarDreams.service.InscripcionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InscripcionServiceImpl implements InscripcionService {

    @Autowired
    private InscripcionDao inscripcionDao;

    @Transactional(readOnly = true)
    @Override
    public List<Inscripcion> getInscripcions(Inscripcion inscripcion) {
        var lista = inscripcionDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Inscripcion getInscripcion(Inscripcion inscripcion) {
        return inscripcionDao.findById(inscripcion.getIdInscripcion()).orElse(null);
    }

    @Transactional
    @Override
    public void save(Inscripcion inscripcion) {
        inscripcionDao.save(inscripcion);

    }

    @Transactional
    @Override
    public void delete(Inscripcion inscripcion) {
        inscripcionDao.delete(inscripcion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Inscripcion> usuario(Usuario usuario) {
        return inscripcionDao.findByUsuario(usuario);
    }

}
