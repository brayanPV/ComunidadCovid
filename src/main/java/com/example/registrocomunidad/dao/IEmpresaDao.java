package com.example.registrocomunidad.dao;

import com.example.registrocomunidad.entities.Empresa;

import org.springframework.data.repository.CrudRepository;

public interface IEmpresaDao extends CrudRepository<Empresa, Long> {
    
}
