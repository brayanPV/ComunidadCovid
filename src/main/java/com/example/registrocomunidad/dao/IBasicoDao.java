package com.example.registrocomunidad.dao;

import com.example.registrocomunidad.entities.Basico;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IBasicoDao extends CrudRepository<Basico, Long>{
    
    @Query("select b from Basico b where b.documento = ?1")
    Basico findByDocumento(String documento);
}
