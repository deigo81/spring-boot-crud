package com.codesnippet.springbootcrudh2.service;


import com.codesnippet.springbootcrudh2.dao.IComEntityDAO;
import com.codesnippet.springbootcrudh2.entity.ComEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComEntityServiceImpl implements IComEnityService {

    @Autowired
    IComEntityDAO dao;

    @Override
    public Iterable<ComEntity> findAll() {
        Iterable<ComEntity> list = dao.findAll();
        return list;
    }

    @Override
    public ComEntity save(ComEntity c) {
        return dao.save(c);
    }

    @Override
    public void delete(Long id) {
         dao.deleteById(id);
    }

    @Override
    public Optional<ComEntity> findId(Long id) {
       return dao.findById(id);
    }


}
