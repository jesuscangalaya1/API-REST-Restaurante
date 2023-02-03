package com.crud.PracticandoDWEC.dao;

import com.crud.PracticandoDWEC.entity.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Long> {


}
