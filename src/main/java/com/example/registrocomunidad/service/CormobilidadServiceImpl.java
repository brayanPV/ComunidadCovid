package com.example.registrocomunidad.service;

import com.example.registrocomunidad.dao.ICormobilidadDao;
import com.example.registrocomunidad.entities.Cormobilidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CormobilidadServiceImpl implements ICormobilidadService {

    @Lazy
    @Autowired
    private ICormobilidadDao cormobilidadDao;

    @Override
    public void save(Cormobilidad cormobilidad) {
        // TODO Auto-generated method stub
        cormobilidadDao.save(cormobilidad);
    }

    @Override
    public Cormobilidad findById(Long id) {
        // TODO Auto-generated method stub
        return cormobilidadDao.findById(id).orElse(null);
    }
    
}
