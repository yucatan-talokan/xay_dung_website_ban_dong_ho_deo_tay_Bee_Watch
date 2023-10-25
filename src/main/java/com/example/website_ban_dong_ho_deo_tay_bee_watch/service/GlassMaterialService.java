package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.IGlassMaterialDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.GlassMaterial;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.IGlassMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public class GlassMaterialService implements IGlassMaterialService {
    @Autowired
    IGlassMaterialDao glassMaterialDao;
    @Override
    public ArrayList<GlassMaterial> getAll() {
        return (ArrayList<GlassMaterial>) glassMaterialDao.findAll();
    }

    @Override
    public GlassMaterial add(GlassMaterial glassMaterial) {
        return glassMaterialDao.save(glassMaterial);
    }

    @Override
    public void delete(UUID id) {
        glassMaterialDao.deleteById(id);
    }

    @Override
    public GlassMaterial update(UUID id, GlassMaterial glassMaterial) {
        Optional<GlassMaterial> optional = glassMaterialDao.findById(id);
        if (optional.isPresent()){
            GlassMaterial shellMaterial1 = optional.get();
            shellMaterial1.setCode(shellMaterial1.getCode());
            shellMaterial1.setName(shellMaterial1.getName());
            glassMaterialDao.save(shellMaterial1);
            return shellMaterial1;
        }
        return null;
    }
    @Override
    public GlassMaterial findById(UUID id) {
        Optional<GlassMaterial> glassMaterialOptional = glassMaterialDao.findById(id);
        if (glassMaterialOptional.isPresent()) {
            return glassMaterialOptional.get();
        }else {
            System.out.printf("Not found Strap with id:" + id);
        }
        return null;
    }
}
