package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.ShellColorDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.ShellColor;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.ShellMaterial;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.ShellColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public class IShellColerService implements ShellColorService {
    @Autowired
    ShellColorDao shellColorDao;
    @Override
    public ArrayList<ShellColor> getAll() {
        return (ArrayList<ShellColor>) shellColorDao.findAll();
    }

    @Override
    public ShellColor add(ShellColor shellColor) {
        return shellColorDao.save(shellColor);
    }

    @Override
    public void delete(UUID id) {
        shellColorDao.deleteById(id);
    }

    @Override
    public ShellColor update(UUID id, ShellColor shellColor) {
        Optional<ShellColor> optional = shellColorDao.findById(id);
        if (optional.isPresent()){
            ShellColor shellMaterial1 = optional.get();
            shellMaterial1.setCode(shellMaterial1.getCode());
            shellMaterial1.setName(shellMaterial1.getName());
            shellColorDao.save(shellMaterial1);
            return shellMaterial1;
        }
        return null;
    }
}
