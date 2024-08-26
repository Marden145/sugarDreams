package com.sugarDreams.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table (name="comentarios")
public class Comentarios  implements Serializable {
  private static  final long serialVersionUID=1L;
  
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name = "id_comentario")
    private Long idcomentario;
    private String comentario;
    @ManyToOne
    @JoinColumn(name = "id_usuario",updatable= false)
    private Usuario usuario;
    
}