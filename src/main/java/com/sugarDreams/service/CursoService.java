/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sugarDreams.service;

import com.sugarDreams.domain.Curso;
import java.util.List;

public interface CursoService {

    public List<Curso> getCursos(Curso curso);

    public Curso getIdCurso(Curso curso);

    public void save(Curso curso);

    public void delete(Curso curso);

}
