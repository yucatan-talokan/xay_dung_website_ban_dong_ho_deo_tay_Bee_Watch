package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Size;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;

import java.util.ArrayList;
import java.util.UUID;

public interface ISizeService{
    ArrayList<Size> getAll();
    Size add(Size size);
    void delete(UUID id);
    Size update(UUID id, Size size);
    Size findById(UUID id);
}
