package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.BrandDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.StrapDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Brand;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public class BrandService implements IBrandService {
    @Autowired
    BrandDao brandDao;
    @Override
    public ArrayList<Brand> getAll() {
        return (ArrayList<Brand>) brandDao.findAll();
    }

    @Override
    public Brand add(Brand brand) {
        return brandDao.save(brand);
    }

    @Override
    public void delete(UUID id) {
        brandDao.deleteById(id);
    }

    @Override
    public Brand update(UUID id, Brand brand) {
        Optional<Brand> optional = brandDao.findById(id);
        if (optional.isPresent()){
            Brand brandOp = optional.get();
            brandOp.setCode(brand.getCode());
            brandOp.setName(brand.getName());
            brandDao.save(brandOp);
            return brandOp;
        }
        return null;
    }
    @Override
    public Brand findById(UUID id) {
        Optional<Brand> brandOptional = brandDao.findById(id);
        if (brandOptional.isPresent()) {
            return brandOptional.get();
        }else {
            System.out.printf("Not found Strap with id:" + id);
        }
        return null;
    }
}
