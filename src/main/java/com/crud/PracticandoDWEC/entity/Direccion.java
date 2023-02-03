package com.crud.PracticandoDWEC.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

@NoArgsConstructor
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;

    @OneToOne(cascade = CascadeType.ALL)
    private Restaurante restaurante;

    public Direccion(Long id, String calle, Restaurante restaurante) {
        this.id = id;
        this.calle = calle;
        this.restaurante = restaurante;
    }
}
