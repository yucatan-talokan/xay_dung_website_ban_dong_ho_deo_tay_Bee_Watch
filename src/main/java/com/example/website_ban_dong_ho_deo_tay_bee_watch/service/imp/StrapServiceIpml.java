package com.example.demo.service.impl;

import com.example.demo.DAO.StrapDao;
import com.example.demo.entity.Strap;
import com.example.demo.service.StrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class StrapServiceIpml implements StrapService {
    @Autowired
    StrapDao strapDao;
    @Override
    public ArrayList<Strap> getAll() {
        return (ArrayList<Strap>) strapDao.findAll();
    }

    @Override
    public Strap add(Strap strap) {
        return strapDao.save(strap);
    }

    @Override
    public void delete(UUID id) {
        strapDao.deleteById(id);
    }

    @Override
    public Strap update(UUID id, Strap strap) {
        return null;
    }
}
