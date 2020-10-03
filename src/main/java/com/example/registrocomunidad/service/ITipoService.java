package com.example.registrocomunidad.service;

import java.util.List;

import com.example.registrocomunidad.entities.Empresa;
import com.example.registrocomunidad.entities.Tipo;

public interface ITipoService {
    
    public Tipo findById(Long id);

    public Tipo findByDescripcionAndEmpresa(String descripcion, Empresa empresa);

    public List<Tipo> findByEmpresa(Empresa empresa);
}
