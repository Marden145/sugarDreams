
package com.sugarDreams.dao;

import com.sugarDreams.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto,Long>{

}
