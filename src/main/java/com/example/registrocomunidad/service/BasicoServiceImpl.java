package com.example.registrocomunidad.service;

import com.example.registrocomunidad.entities.Basico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BasicoServiceImpl implements IBasicoService {

    @Autowired
    private IBasicoService basicoDao;

    @Override
    public void save(Basico basico) {
        // TODO Auto-generated method stub
        basicoDao.save(basico);
    }

    @Override
    @Transactional(readOnly = true)
    public Basico findByDocumento(String documento) {
        // TODO Auto-generated method stub
        return basicoDao.findByDocumento(documento);
    }
    
}