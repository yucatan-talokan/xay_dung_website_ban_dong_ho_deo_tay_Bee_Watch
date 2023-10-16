package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.StrapDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.StrapService;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.StrapService;
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
