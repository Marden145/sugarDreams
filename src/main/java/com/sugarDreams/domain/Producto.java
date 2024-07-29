
package com.sugarDreams.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author indira
 */
@Data
@Entity
@Table (name="producto")
public class Producto implements Serializable{
    
    private static final Long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_producto")
    
    private long idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private long   existencias;
    private String rutaImagen;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}