package com.example.registrocomunidad.service;

import java.util.List;

import com.example.registrocomunidad.entities.Basico;

import org.springframework.data.jpa.repository.Query;

public interface IBasicoService {

    public void save(Basico basico);

    public Basico findByDocumento(String documento);
}
