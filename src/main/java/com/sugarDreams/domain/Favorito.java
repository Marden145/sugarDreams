package com.sugarDreams.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "favorito")

public class Favorito implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_favorito")
    private long idFavorito;
    @ManyToOne
    @JoinColumn (name="id_producto",updatable= false)
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "id_usuario",updatable= false)
    private Usuario usuario;
}
