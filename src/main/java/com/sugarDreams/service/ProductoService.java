
package com.sugarDreams.service;



import com.sugarDreams.domain.Producto;
import java.util.List;

/**
 *
 * @author indir
 */
public interface ProductoService {
        

public List<Producto> getProductos(boolean activo);    
public Producto getProducto(Producto producto); 
public void save (Producto producto);
public void delete (Producto producto);
}
