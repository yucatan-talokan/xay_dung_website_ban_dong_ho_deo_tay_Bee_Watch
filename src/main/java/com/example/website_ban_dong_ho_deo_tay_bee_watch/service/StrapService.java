package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.StrapDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.UUID;

public interface StrapService{
        ArrayList<Strap> getAll();
        Strap add(Strap strap);
        void delete(UUID id);
        Strap update(UUID id, Strap strap);
}
