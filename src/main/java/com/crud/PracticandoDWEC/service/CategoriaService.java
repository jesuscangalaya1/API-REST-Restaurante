package com.crud.PracticandoDWEC.service;

import com.crud.PracticandoDWEC.dao.CategoriaRepository;
import com.crud.PracticandoDWEC.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Optional<Categoria> getByCategoria(String categoria) {
        return categoriaRepository.findByCategoria(categoria);
    }

    public boolean existsByCategoria(String categoria) {
        return categoriaRepository.existsByCategoria(categoria);
    }

    public List<Categoria> list(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> getOne(Long id) {
        return categoriaRepository.findById(id);
    }

    public void save(Categoria categoria){
        categoriaRepository.save(categoria);
    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}
