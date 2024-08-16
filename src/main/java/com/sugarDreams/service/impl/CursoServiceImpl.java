package com.sugarDreams.service.impl;

import com.sugarDreams.dao.CursoDao;
import com.sugarDreams.domain.Curso;
import com.sugarDreams.service.CursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoDao cursoDao;

    @Transactional(readOnly = true)
    @Override
    public List<Curso> getCursos(Curso curso) {
        var lista = cursoDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Curso getIdCurso(Curso curso) {
        return cursoDao.findById(curso.getIdCurso()).orElse(null);
    }

    @Transactional
    @Override
    public void save(Curso curso) {
        cursoDao.save(curso);

    }

    @Transactional
    @Override
    public void delete(Curso curso) {
        cursoDao.delete(curso);
    }

}
