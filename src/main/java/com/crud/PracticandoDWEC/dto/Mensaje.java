package com.crud.PracticandoDWEC.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Mensaje {

    private String nombre;

    public Mensaje(String nombre) {
        this.nombre = nombre;
    }

    public Mensaje() {
    }
}
