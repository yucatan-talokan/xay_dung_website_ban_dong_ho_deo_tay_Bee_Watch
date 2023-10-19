package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.GenderDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.StrapDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Gender;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class GenderService implements IGenderService {
    @Autowired
    GenderDao genderDao;
    @Override
    public ArrayList<Gender> getAll() {
        return (ArrayList<Gender>) genderDao.findAll();
    }

    @Override
    public Gender add(Gender gender) {
        return genderDao.save(gender);
    }

    @Override
    public void delete(UUID id) {
        genderDao.deleteById(id);
    }

    @Override
    public Gender update(UUID id, Gender gender) {
        Optional<Gender> optional = genderDao.findById(id);
        if (optional.isPresent()){
            Gender gender1 = optional.get();
            gender1.setCode(gender.getCode());
            gender1.setName(gender.getName());
            genderDao.save(gender1);
            return gender1;
        }
        return null;
    }
    @Override
    public Gender findById(UUID id) {
        Optional<Gender> genderOptional = genderDao.findById(id);
        if (genderOptional.isPresent()) {
            return genderOptional.get();
        }else {
            System.out.printf("Not found Strap with id:" + id);
        }
        return null;
    }
}
