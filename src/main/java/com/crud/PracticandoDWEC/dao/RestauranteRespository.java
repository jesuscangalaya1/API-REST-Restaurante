package com.crud.PracticandoDWEC.dao;

import com.crud.PracticandoDWEC.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestauranteRespository extends JpaRepository<Restaurante, Long> {

        Optional<Restaurante> findByNombre(String nombre);
        boolean existsByNombre(String nombre);

}
