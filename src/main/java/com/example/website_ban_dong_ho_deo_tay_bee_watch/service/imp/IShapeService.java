package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Shape;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
@Service
public interface IShapeService {
    ArrayList<Shape> getAll();
    Shape add(Shape shape);
    void delete(UUID id);
    Shape update(UUID id, Shape shape);
    Shape findById(UUID id);
}
