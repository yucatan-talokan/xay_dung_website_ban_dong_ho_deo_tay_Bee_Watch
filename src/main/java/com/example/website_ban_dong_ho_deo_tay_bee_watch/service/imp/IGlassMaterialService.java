package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.GlassMaterial;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
@Service
public interface IGlassMaterialService {
    ArrayList<GlassMaterial> getAll();
    GlassMaterial add(GlassMaterial glassMaterial);
    void delete(UUID id);
    GlassMaterial update(UUID id, GlassMaterial glassMaterial);
    GlassMaterial findById(UUID id);
}
