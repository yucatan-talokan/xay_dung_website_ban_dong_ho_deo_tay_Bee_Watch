package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.ISizeDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Size;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public class SizeService implements ISizeService {
    @Autowired
    ISizeDao sizeDao;
    @Override
    public ArrayList<Size> getAll() {
        return (ArrayList<Size>) sizeDao.findAll();
    }

    @Override
    public Size add(Size size) {
        return sizeDao.save(size);
    }

    @Override
    public void delete(UUID id) {
        sizeDao.deleteById(id);
    }

    @Override
    public Size update(UUID id, Size size) {
        Optional<Size> optional = sizeDao.findById(id);
        if (optional.isPresent()){
            Size size1 = optional.get();
            size1.setCode(size.getCode());
            size1.setName(size.getName());
            sizeDao.save(size1);
            return size1;
        }
        return null;
    }
    @Override
    public Size findById(UUID id) {
        Optional<Size> sizeOptional = sizeDao.findById(id);
        if (sizeOptional.isPresent()) {
                return sizeOptional.get();
        }else {
            System.out.printf("Not found Strap with id:" + id);
        }
        return null;
    }
}
