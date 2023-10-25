package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.IShapeDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Shape;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.IShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public class ShapeService implements IShapeService {
    @Autowired
    IShapeDao shapeDao;
    @Override
    public ArrayList<Shape> getAll() {
        return (ArrayList<Shape>) shapeDao.findAll();
    }

    @Override
    public Shape add(Shape shape) {
        return shapeDao.save(shape);
    }

    @Override
    public void delete(UUID id) {
        shapeDao.deleteById(id);
    }

    @Override
    public Shape update(UUID id, Shape shape) {
        Optional<Shape> optional = shapeDao.findById(id);
        if (optional.isPresent()){
            Shape shellMaterial1 = optional.get();
            shellMaterial1.setCode(shellMaterial1.getCode());
            shellMaterial1.setName(shellMaterial1.getName());
            shapeDao.save(shellMaterial1);
            return shellMaterial1;
        }
        return null;
    }
    @Override
    public Shape findById(UUID id) {
        Optional<Shape> shapeOptional = shapeDao.findById(id);
        if (shapeOptional.isPresent()) {
            return shapeOptional.get();
        }else {
            System.out.printf("Not found Strap with id:" + id);
        }
        return null;
    }
}
