/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sugarDreams.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table (name="usuario")
public class Usuario implements Serializable{
    private static  final long serialVersionUID=1L;
  
    @Id// para decir que es una llave primaria
    
    // la estrategia para generar los valores de categoria tome da manera idenmtica como estan en la bd
   
   @GeneratedValue(strategy = GenerationType.IDENTITY)

    
    @Column (name = "id_usuario")
    private Long idUsuario;
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String rutaImagen;
    private boolean activo;
    
    @OneToMany
    @JoinColumn (name="id_usuario")
    private List<Rol> roles;
}
