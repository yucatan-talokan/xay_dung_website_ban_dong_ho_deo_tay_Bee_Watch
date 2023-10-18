package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.StrapDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.StrapService;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.StrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public interface IStrapService {
    ArrayList<Strap> getAll();
    Strap add(Strap strap);
    void delete(UUID id);
    Strap update(UUID id, Strap strap);
}
