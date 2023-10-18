package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.CaseMaterialDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.CaseMaterial;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.CaseMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public class ICaseMaterial implements CaseMaterialService {
    @Autowired
    CaseMaterialDao caseMaterialDao;

    @Override
    public ArrayList<CaseMaterial> getAll() {
        return (ArrayList<CaseMaterial>) caseMaterialDao.findAll();
    }

    @Override
    public CaseMaterial add(CaseMaterial caseMaterial) {
        return caseMaterialDao.save(caseMaterial);
    }

    @Override
    public void delete(UUID id) {
        caseMaterialDao.deleteById(id);
    }

    @Override
    public CaseMaterial update(UUID id, CaseMaterial caseMaterial) {
        Optional<CaseMaterial> optional = caseMaterialDao.findById(id);
        if (optional.isPresent()){
            CaseMaterial caseMaterial1 = optional.get();
            caseMaterial1.setCode(caseMaterial1.getCode());
            caseMaterial1.setName(caseMaterial1.getName());
            caseMaterialDao.save(caseMaterial1);
            return caseMaterial1;
        }
        return null;
    }
}
