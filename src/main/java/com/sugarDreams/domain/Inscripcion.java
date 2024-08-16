package com.sugarDreams.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "inscripcion")

public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Long idInscripcion;
    @ManyToOne
    @JoinColumn(name = "id_curso", updatable = false)
    private Curso curso;
    @ManyToOne
    @JoinColumn(name = "id_usuario", updatable = false)
    private Usuario usuario;
}
