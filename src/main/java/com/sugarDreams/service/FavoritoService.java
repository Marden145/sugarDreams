
package com.sugarDreams.service;

import com.sugarDreams.domain.Favorito;
import com.sugarDreams.domain.Usuario;
import java.util.List;
public interface FavoritoService {
    
    
public List<Favorito> getFavoritos(Favorito favorito);    
public Favorito getFavorito(Favorito favorito); 
public void save (Favorito favorito);
public void delete (Favorito favorito);
 public List<Favorito> usuario(Usuario usuario);
    
}
