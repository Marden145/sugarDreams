
package com.sugarDreams.dao;

import com.sugarDreams.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto,Long>{
//Ejemplo de método utilizando métodos de consulta
public List<Producto> findByNombre(String nombre);
}