package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.ImagesDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Image;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.IImagesSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public class ImagesService implements IImagesSevice {
    @Autowired
    ImagesDao imagesDao;
    @Override
    public ArrayList<Image> getAll() {
        return (ArrayList<Image>) imagesDao.findAll();
    }

    @Override
    public Image add(Image images) {
        return imagesDao.save(images);
    }

    @Override
    public void delete(UUID id) {
        imagesDao.deleteById(id);
    }

    @Override
    public Image update(UUID id, Image images) {
        Optional<Image> optional = imagesDao.findById(id);
        if (optional.isPresent()){
            Image shellMaterial1 = optional.get();
            shellMaterial1.setCode(shellMaterial1.getCode());
            shellMaterial1.setName(shellMaterial1.getName());
            imagesDao.save(shellMaterial1);
            return shellMaterial1;
        }
        return null;
    }
}
