package com.example.registrocomunidad.service;

import com.example.registrocomunidad.entities.Empresa;
import com.example.registrocomunidad.entities.Tipo;

public interface ITipoService {
    
    public Tipo findById(Long id);

    public Tipo findByDescripcionAndEmpresa(String descripcion, Empresa empresa);
}
