package com.sugarDreams.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "inscripcion")

public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private long idInscripcionCurso;
    @ManyToOne
    @JoinColumn(name = "id_curso", updatable = false)
    private Curso curso;
    @ManyToOne
    @JoinColumn(name = "id_usuario", updatable = false)
    private Usuario usuario;
}
