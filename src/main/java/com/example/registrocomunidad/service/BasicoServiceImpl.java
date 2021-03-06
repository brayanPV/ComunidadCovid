package com.example.registrocomunidad.service;

import java.util.List;

import com.example.registrocomunidad.dao.IBasicoDao;
import com.example.registrocomunidad.entities.Basico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Lazy
@Service
public class BasicoServiceImpl implements IBasicoService {

    @Autowired
    private IBasicoDao basicoDao;

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

    @Override
    public Basico findById(Long id) {
        // TODO Auto-generated method stub
        return basicoDao.findById(id).orElse(null);
    }
    
}
