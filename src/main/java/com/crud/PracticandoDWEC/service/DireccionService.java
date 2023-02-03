package com.crud.PracticandoDWEC.service;

import com.crud.PracticandoDWEC.dao.DirrecionRespository;
import com.crud.PracticandoDWEC.entity.Categoria;
import com.crud.PracticandoDWEC.entity.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DireccionService {

    @Autowired
    private DirrecionRespository direccionRepository;

    public Optional<Direccion> getByCalle(String calle) {
        return direccionRepository.findByCalle(calle);
    }

    public boolean existsByCalle(String calle) {
        return direccionRepository.existsByCalle(calle);
    }

    public List<Direccion> list(){
        return direccionRepository.findAll();
    }

    public Optional<Direccion> getOne(Long id) {
        return direccionRepository.findById(id);
    }

    public void save(Direccion direccion){
        direccionRepository.save(direccion);
    }

    public void delete(Long id) {
        direccionRepository.deleteById(id);
    }
}
