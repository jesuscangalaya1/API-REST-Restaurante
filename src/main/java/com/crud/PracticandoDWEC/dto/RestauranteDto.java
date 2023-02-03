package com.crud.PracticandoDWEC.dto;



import com.crud.PracticandoDWEC.entity.Categoria;
import com.crud.PracticandoDWEC.entity.Direccion;
import com.crud.PracticandoDWEC.entity.Imagen;
import lombok.Getter;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class RestauranteDto {

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

    @Autowired
    private Categoria categoria;

    @Autowired
    private Direccion direccion;

    @Autowired
    private List<Imagen> imagenes;

    public RestauranteDto(String nombre, String descripcion, Categoria categoria, Direccion direccion, List<Imagen> imagenes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.direccion = direccion;
        this.imagenes = imagenes;
    }

    public RestauranteDto() {
    }
}
