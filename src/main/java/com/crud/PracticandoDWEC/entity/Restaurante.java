package com.crud.PracticandoDWEC.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter

@NoArgsConstructor
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="categoria_id", nullable = true)
    private Categoria categoria;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
    private List<Imagen> imagenes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dirreccion_id", nullable = true)
    private Direccion direccion;

    public Restaurante(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Restaurante(Long id, String nombre, String descripcion, Categoria categoria, List<Imagen> imagenes, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.imagenes = imagenes;
        this.direccion = direccion;
    }

    public Restaurante(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
