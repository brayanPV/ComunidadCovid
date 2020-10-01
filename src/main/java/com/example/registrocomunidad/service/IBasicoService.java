package com.example.registrocomunidad.service;

import com.example.registrocomunidad.entities.Basico;

public interface IBasicoService {

    public void save(Basico basico);

    public Basico findByDocumento(String documento);
}
