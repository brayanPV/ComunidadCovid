package com.example.registrocomunidad.dao;

import com.example.registrocomunidad.entities.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
    
}
