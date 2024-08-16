
package com.sugarDreams.domain;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table (name="curso")
public class Curso implements Serializable{
    private static  final long serialVersionUID=1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_curso")
    private Long idCurso;
    private String descripcion;
    private double precio;
    private String duracion;
    private String nombre;
    private String modalidad;
    private String material;
    private String nivel;
    private String categoria;
}