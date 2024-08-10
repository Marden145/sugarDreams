
package com.sugarDreams.dao;

import com.sugarDreams.domain.Favorito;
import com.sugarDreams.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritoDao extends JpaRepository<Favorito,Long>{

public List<Favorito> findByUsuario(Usuario usuario);
}