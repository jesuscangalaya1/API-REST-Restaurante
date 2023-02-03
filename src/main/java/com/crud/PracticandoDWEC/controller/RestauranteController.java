package com.crud.PracticandoDWEC.controller;

import com.crud.PracticandoDWEC.dto.Mensaje;
import com.crud.PracticandoDWEC.dto.RestauranteDto;
import com.crud.PracticandoDWEC.entity.Categoria;
import com.crud.PracticandoDWEC.entity.Direccion;
import com.crud.PracticandoDWEC.entity.Imagen;
import com.crud.PracticandoDWEC.entity.Restaurante;
import com.crud.PracticandoDWEC.service.CategoriaService;
import com.crud.PracticandoDWEC.service.DireccionService;
import com.crud.PracticandoDWEC.service.RestauranteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/restaurantes")
@CrossOrigin
public class RestauranteController {

    @Autowired
    private RestauranteService service;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private DireccionService direccionService;


    @GetMapping("/lista")
    public ResponseEntity<List<Restaurante>> List() {
        List<Restaurante> list = service.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Restaurante> getById(@PathVariable Long id) {
        if (!service.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        if (service.getOne(id).isPresent()) {
            Restaurante restaurante = service.getOne(id).get();
            return new ResponseEntity<>(restaurante, HttpStatus.OK);
        }
        return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Restaurante> getByNombre(@PathVariable String nombre) {
        if (!service.existsByNombre(nombre)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        if (service.getByNombre(nombre).isPresent()) {
            Restaurante restaurante = service.getByNombre(nombre).get();
            return new ResponseEntity<>(restaurante, HttpStatus.OK);
        }
        return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody RestauranteDto restauranteDto) {
        if (StringUtils.isBlank(restauranteDto.getNombre())) {
            return new ResponseEntity<>(new Mensaje("El nombre no existe"), HttpStatus.BAD_REQUEST);
        }
        if (service.existsByNombre(restauranteDto.getNombre())) {
            return new ResponseEntity<>(new Mensaje("El nombre no existe"), HttpStatus.BAD_REQUEST);
        }

        Categoria categoria;
        Restaurante restaurante = new Restaurante(restauranteDto.getNombre(), restauranteDto.getNombre());
        service.save(restaurante);
        return new ResponseEntity<>(new Mensaje("Restaurante Creado"), HttpStatus.OK);

//        //CATEGORIA:
//        if (categoriaService.getByCategoria(restauranteDto.getCategoria().getCategoria()).isPresent()) {
//            categoria = categoriaService.getByCategoria(restauranteDto.getCategoria().getCategoria()).get();
//            restaurante.setCategoria(categoria);
//        } else {
//            Categoria categoriaNew = restauranteDto.getCategoria();
//            restaurante.setCategoria(categoriaNew);
//            if (categoriaNew.getRestaurantes() != null) {
//                categoriaNew.getRestaurantes().add(restaurante);
//            } else {
//                List<Restaurante> restaurantes = (List<Restaurante>) new HashSet<Restaurante>();
//                restaurantes.add(restaurante);
//                categoriaNew.setRestaurantes(restaurantes);
//            }
//        }
//        //IMAGEN:
//        List<Imagen> imagenes = restauranteDto.getImagenes();
//        for (Imagen imagen : imagenes) {
//            imagen.setRestaurante(restaurante);
//        }
//        restaurante.setImagenes(imagenes);
//
//        //DIRECCION:
//        if (direccionService.existsByCalle(restauranteDto.getDireccion().getCalle())) {
//            return new ResponseEntity<>(new Mensaje("La direccion ya existe"), HttpStatus.BAD_REQUEST);
//        } else {
//            Direccion direccion = restauranteDto.getDireccion();
//            restaurante.setDireccion(direccion);
//            direccion.setRestaurante(restaurante);
//        }
//        direccionService.save(restaurante);
//        return new ResponseEntity<>(new Mensaje("restaurante creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RestauranteDto restauranteDto) {
        //Si no existe el id el restaurante no existe.
        if (!service.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        //Si existe Por nombre y el id es distinto del que me han dado,
        // es que ya esxiste un restaurante con ese nombre.
        if (service.existsByNombre(restauranteDto.getNombre())
                && service.getByNombre(restauranteDto.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(restauranteDto.getNombre())) {
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        //Hechas la comprobaciones, cojo el restaurante de la bd y actualizo
        Restaurante restaurante = service.getOne(id).get();
        restaurante.setNombre(restauranteDto.getNombre());
        restaurante.setDescripcion(restauranteDto.getDescripcion());

        //Una vez relleanada la informacion la actualizo en la bd.
        service.save(restaurante);
        return new ResponseEntity<>(new Mensaje("Restaurante Actiualizado"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!service.existsById(id)) {
            return new ResponseEntity<>(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(new Mensaje("Eliminado"), HttpStatus.OK);
    }
}


