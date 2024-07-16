package com.sugarDreams.dao;


import com.sugarDreams.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao
        extends JpaRepository<Categoria, Long> {

}
