package com.example.registrocomunidad.service;

import com.example.registrocomunidad.dao.IEmpresaDao;
import com.example.registrocomunidad.entities.Empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaServiceImpl implements IEmpresaService {
    @Lazy
    @Autowired
    private IEmpresaDao empresaDao;

    @Override
    @Transactional(readOnly = true)
    public Empresa findOne(Long id) {
        // TODO Auto-generated method stub
        return empresaDao.findById(id).orElse(null);
    }
    
}
