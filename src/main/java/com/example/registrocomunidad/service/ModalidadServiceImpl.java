package com.example.registrocomunidad.service;

import java.util.List;

import com.example.registrocomunidad.dao.IModalidadDao;
import com.example.registrocomunidad.entities.Modalidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ModalidadServiceImpl implements IModalidadService {


    @Lazy
    @Autowired
    private IModalidadDao modalidadDao;
    @Override
    public List<Modalidad> findAll() {
        // TODO Auto-generated method stub
        return (List<Modalidad>) modalidadDao.findAll();
    }
    
}
