package com.alkemy.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pelicula_genero_id", insertable = false, updatable = false) /* FK */
    private Set<PeliculaEntity> peliculas= new HashSet<>();

}
