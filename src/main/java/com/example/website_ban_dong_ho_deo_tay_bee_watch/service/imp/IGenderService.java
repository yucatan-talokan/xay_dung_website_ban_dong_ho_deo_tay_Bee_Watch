package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Gender;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;

import java.util.ArrayList;
import java.util.UUID;

public interface IGenderService {
    ArrayList<Gender> getAll();
    Gender add(Gender gender);
    void delete(UUID id);
    Gender update(UUID id, Gender gender);
    Gender findById(UUID id);
}
