package com.sugarDreams.service;

import com.sugarDreams.domain.Comentarios;
import java.util.List;

public interface ComentariosService {

    public List<Comentarios> getComentarioss(boolean activo);

    public Comentarios getComentarios(Comentarios comentarios);

    public void save(Comentarios comentarios);

}
