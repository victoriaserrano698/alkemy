package com.alkemy.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pelicula")
@Data

public class PeliculaEntity {

    @Id
    @Column(name = "pelicula_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long peliculaId;

    private String imagen;
    private String titulo;

    @Column (name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;

    private Integer calificacion;

    @ManyToMany(cascade = {
                            CascadeType.PERSIST,
                            CascadeType.MERGE
                    })
    @JoinTable(name = "personaje_pelicula",
        joinColumns = @JoinColumn(name = "pelicula_id"),
        inverseJoinColumns = @JoinColumn(name = "personaje_id"))
        private Set<PersonajeEntity> personajes= new HashSet<>();

}