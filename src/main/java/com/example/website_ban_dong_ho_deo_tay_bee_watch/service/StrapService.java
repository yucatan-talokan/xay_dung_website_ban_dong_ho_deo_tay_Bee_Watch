package com.example.demo.service;

import com.example.demo.DAO.StrapDao;
import com.example.demo.entity.Strap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.UUID;

public interface StrapService{
        ArrayList<Strap> getAll();
        Strap add(Strap strap);
        void delete(UUID id);
        Strap update(UUID id, Strap strap);
}
