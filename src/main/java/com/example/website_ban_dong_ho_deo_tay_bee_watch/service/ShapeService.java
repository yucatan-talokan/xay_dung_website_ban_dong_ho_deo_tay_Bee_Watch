package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Shape;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
@Service
public interface ShapeService{
    ArrayList<Shape> getAll();
    Shape add(Shape shape);
    void delete(UUID id);
    Shape update(UUID id, Shape shape);
}
