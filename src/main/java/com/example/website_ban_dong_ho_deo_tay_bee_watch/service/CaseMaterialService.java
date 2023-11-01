package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.ICaseMaterialDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.CaseMaterial;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.ICaseMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public class CaseMaterialService implements ICaseMaterial {
    @Autowired
    ICaseMaterialDao caseMaterialDao;

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
    @Override
    public CaseMaterial findById(UUID id) {
        Optional<CaseMaterial> caseMaterialOptional = caseMaterialDao.findById(id);
        if (caseMaterialOptional.isPresent()) {
            return caseMaterialOptional.get();
        }else {
            System.out.printf("Not found Strap with id:" + id);
        }
        return null;
    }
}
