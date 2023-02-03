package com.crud.PracticandoDWEC.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurante_id", nullable = false)
    private Restaurante restaurante;
}
