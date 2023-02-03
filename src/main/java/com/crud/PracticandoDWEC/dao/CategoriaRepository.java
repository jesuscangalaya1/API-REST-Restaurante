package com.crud.PracticandoDWEC.dao;

import com.crud.PracticandoDWEC.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByCategoria(String categoria);
    boolean existsByCategoria(String categoria);
}
