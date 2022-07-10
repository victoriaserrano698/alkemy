package com.alkemy.disney.disney.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "genero")
public class GeneroEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;
    private String imagen;

    @Column(name = "pelicula_id",nullable = true)
    private Long peliculaId;

    @ManyToMany(mappedBy = "peliculas", fetch = FetchType.EAGER)
    @JoinColumn(name = "pelicula_id", insertable = true, updatable = true)
    private List<PeliculaEntity> peliculas= new ArrayList<>();
}
