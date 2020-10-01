package com.example.registrocomunidad.dao;

import com.example.registrocomunidad.entities.Empresa;
import com.example.registrocomunidad.entities.Tipo;

import org.springframework.data.repository.CrudRepository;

public interface ITipoDao extends CrudRepository<Tipo, Long> {
    
    Tipo findByDescripcionAndEmpresa(String descripcion, Empresa empresa);
}
