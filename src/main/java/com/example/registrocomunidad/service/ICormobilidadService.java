package com.example.registrocomunidad.service;

import com.example.registrocomunidad.entities.Cormobilidad;

public interface ICormobilidadService {
    
    public void save(Cormobilidad cormobilidad);

    public Cormobilidad findById(Long id);
}
