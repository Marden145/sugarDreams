
package com.sugarDreams.service;

import com.sugarDreams.domain.Inscripcion;
import com.sugarDreams.domain.Usuario;
import java.util.List;
public interface InscripcionService {
    
    
public List<Inscripcion> getInscripcions(Inscripcion inscripcion);    
public Inscripcion getInscripcion(Inscripcion inscripcion); 
public void save (Inscripcion inscripcion);
public void delete (Inscripcion inscripcion);
 public List<Inscripcion> usuario(Usuario usuario);
    
}
