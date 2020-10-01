package com.example.registrocomunidad.service;

import com.example.registrocomunidad.dao.ITipoDao;
import com.example.registrocomunidad.entities.Empresa;
import com.example.registrocomunidad.entities.Tipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoServiceImpl implements ITipoService {

    @Autowired
    ITipoDao tipoDao;

    @Override
    @Transactional(readOnly = true)
    public Tipo findByDescripcionAndEmpresa(String descripcion, Empresa empresa) {
        return tipoDao.findByDescripcionAndEmpresa(descripcion, empresa);
    }

    @Override
    public Tipo findById(Long id) {
        return tipoDao.findById(id).orElse(null);
    }
    
}
