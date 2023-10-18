package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.CaseColorDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.CaseColor;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.CaseColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public class ICaseColerService implements CaseColorService {
    @Autowired
    CaseColorDao caseColorDao;
    @Override
    public ArrayList<CaseColor> getAll() {
        return (ArrayList<CaseColor>) caseColorDao.findAll();
    }

    @Override
    public CaseColor add(CaseColor caseColor) {
        return caseColorDao.save(caseColor);
    }

    @Override
    public void delete(UUID id) {
        caseColorDao.deleteById(id);
    }

    @Override
    public CaseColor update(UUID id, CaseColor caseColor) {
        Optional<CaseColor> optional = caseColorDao.findById(id);
        if (optional.isPresent()){
            CaseColor shellMaterial1 = optional.get();
            shellMaterial1.setCode(shellMaterial1.getCode());
            shellMaterial1.setName(shellMaterial1.getName());
            caseColorDao.save(shellMaterial1);
            return shellMaterial1;
        }
        return null;
    }
}