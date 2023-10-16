package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Images;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
@Service
public interface ImagesService{
    ArrayList<Images> getAll();
    Images add(Images images);
    void delete(UUID id);
    Images update(UUID id, Images images);
}
