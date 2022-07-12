package com.alkemy.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="personaje")
@Data
public class PersonajeEntity {

    @Id
    @Column(name = "personaje_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long personajeId;

    private String imagen;
    private String nombre;
    private Integer edad;
    private Float peso;
    private String historia;

    @ManyToMany(mappedBy = "personajes", fetch = FetchType.EAGER)
    private Set<PeliculaEntity> peliculas= new HashSet<>();
    /* @JoinColumn(name = "pelicula_id", insertable = false, updatable = false) FK */

}
