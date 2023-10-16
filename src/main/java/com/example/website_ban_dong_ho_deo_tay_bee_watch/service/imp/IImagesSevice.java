package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.ImagesDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Images;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.ShellMaterial;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public class IImagesSevice implements ImagesService {
    @Autowired
    ImagesDao imagesDao;
    @Override
    public ArrayList<Images> getAll() {
        return (ArrayList<Images>) imagesDao.findAll();
    }

    @Override
    public Images add(Images images) {
        return imagesDao.save(images);
    }

    @Override
    public void delete(UUID id) {
        imagesDao.deleteById(id);
    }

    @Override
    public Images update(UUID id, Images images) {
        Optional<Images> optional = imagesDao.findById(id);
        if (optional.isPresent()){
            Images shellMaterial1 = optional.get();
            shellMaterial1.setCode(shellMaterial1.getCode());
            shellMaterial1.setName(shellMaterial1.getName());
            imagesDao.save(shellMaterial1);
            return shellMaterial1;
        }
        return null;
    }
}
