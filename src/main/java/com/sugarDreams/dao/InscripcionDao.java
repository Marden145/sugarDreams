
package com.sugarDreams.dao;

import com.sugarDreams.domain.Inscripcion;
import com.sugarDreams.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionDao extends JpaRepository<Inscripcion,Long>{

public List<Inscripcion> findByUsuario(Usuario usuario);
}