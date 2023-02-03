package com.crud.PracticandoDWEC.dao;

import com.crud.PracticandoDWEC.entity.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirrecionRespository extends JpaRepository<Direccion, Long> {
    Optional<Direccion> findByCalle(String calle);
    boolean existsByCalle(String calle);
}
