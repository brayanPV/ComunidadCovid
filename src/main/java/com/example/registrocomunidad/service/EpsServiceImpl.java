package com.example.registrocomunidad.service;

import java.util.List;

import com.example.registrocomunidad.dao.IEpsDao;
import com.example.registrocomunidad.entities.Eps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EpsServiceImpl implements IEpsService {

    @Lazy
    @Autowired
    private IEpsDao epsDao;

    @Override
    @Transactional(readOnly = true)
    public List<Eps> findAll() {
        // TODO Auto-generated method stub
        return (List<Eps>) epsDao.findAll();
    }                           
    
}
