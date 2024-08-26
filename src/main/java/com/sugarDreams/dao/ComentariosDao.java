package com.sugarDreams.dao;


import com.sugarDreams.domain.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentariosDao
        extends JpaRepository<Comentarios, Long> {

}
