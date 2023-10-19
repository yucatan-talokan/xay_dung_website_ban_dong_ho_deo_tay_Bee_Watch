package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.GlassMaterialDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.GlassMaterial;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.GlassMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public interface IGlassMaterialService {
    ArrayList<GlassMaterial> getAll();
    GlassMaterial add(GlassMaterial glassMaterial);
    void delete(UUID id);
    GlassMaterial update(UUID id, GlassMaterial glassMaterial);
    GlassMaterial findById(UUID id);
}
