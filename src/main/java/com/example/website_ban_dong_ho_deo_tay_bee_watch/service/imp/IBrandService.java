package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Brand;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;

import java.util.ArrayList;
import java.util.UUID;

public interface IBrandService {
    ArrayList<Brand> getAll();
    Brand add(Brand brand);
    void delete(UUID id);
    Brand update(UUID id, Brand brand);
    Brand findById(UUID id);
}
