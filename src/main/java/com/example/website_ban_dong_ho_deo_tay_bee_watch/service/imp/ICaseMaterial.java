package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.ShellMaterialDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.ShellMaterial;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.CaseMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public class ICaseMaterial implements CaseMaterialService {
    @Autowired
    ShellMaterialDao shellMaterialDao;

    @Override
    public ArrayList<ShellMaterial> getAll() {
        return (ArrayList<ShellMaterial>) shellMaterialDao.findAll();
    }

    @Override
    public ShellMaterial add(ShellMaterial shellMaterial) {
        return shellMaterialDao.save(shellMaterial);
    }

    @Override
    public void delete(UUID id) {
        shellMaterialDao.deleteById(id);
    }

    @Override
    public ShellMaterial update(UUID id, ShellMaterial shellMaterial) {
        Optional<ShellMaterial> optional = shellMaterialDao.findById(id);
        if (optional.isPresent()){
            ShellMaterial shellMaterial1 = optional.get();
            shellMaterial1.setCode(shellMaterial1.getCode());
            shellMaterial1.setName(shellMaterial1.getName());
            shellMaterialDao.save(shellMaterial1);
            return shellMaterial1;
        }
        return null;
    }
}
