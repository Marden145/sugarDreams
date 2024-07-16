package com.sugarDreams.service;


import com.sugarDreams.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    
    
//Se recupera la lista de catefotias de la tabla de categoria dentro de un arraylist
public List<Categoria> getCategorias(boolean activo);    


//se obtiene un registro de categoria de tipo Categoria
//Si el idCategotia existe .. si no es null

public Categoria getCategoria(Categoria categoria); 




//Se crea un nuevo registro  en la tabla categoria,
//si el objeto Categoria No tiene idCategoria
//Se actualiza  el registro en  la tabla categoria
//Si el objeto Categoria tiene un idCategoria
public void save (Categoria categoria);

//Se elimina el registro en la tabla categoria si
// el idCategoria del objeto existe en la tabla

public void delete (Categoria categoria);
}

