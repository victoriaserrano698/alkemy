package com.alkemy.disney.disney.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="personaje")
@Data
public class PersonajeEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;
    private String nombre;
    private Integer edad;
    private Float peso;
    private String historia;

    @ManyToMany(mappedBy = "personajes", fetch = FetchType.EAGER)
    @JoinColumn(name = "pelicula_id", insertable = true, updatable = true)
    private List<PeliculaEntity> peliculas= new ArrayList<>();

    @Column(name = "pelicula_id",nullable = true)
    private Long peliculaId;
}
