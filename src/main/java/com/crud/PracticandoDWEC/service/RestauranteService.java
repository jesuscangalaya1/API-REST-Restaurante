package com.crud.PracticandoDWEC.service;

import com.crud.PracticandoDWEC.dao.RestauranteRespository;
import com.crud.PracticandoDWEC.entity.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RestauranteService {

    @Autowired
    private RestauranteRespository restauranteRespository;

    public List<Restaurante> list() {
        return restauranteRespository.findAll();
    }

    public Optional<Restaurante> getOne(Long id) {
        return restauranteRespository.findById(id);
    }

    public Optional<Restaurante> getByNombre(String nombre) {
        return restauranteRespository.findByNombre(nombre);
    }

    public void save(Restaurante restaurante) {
        restauranteRespository.save(restaurante);
    }

    public void delete(Long id) {
        restauranteRespository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return restauranteRespository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return restauranteRespository.existsByNombre(nombre);
    }

}


