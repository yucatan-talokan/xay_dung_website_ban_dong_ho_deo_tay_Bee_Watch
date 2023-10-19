package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.ImagesDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Image;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.MachineType;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public interface IImagesSevice {
    ArrayList<Image> getAll();
    Image add(Image images);
    void delete(UUID id);
    Image update(UUID id, Image images);
}
