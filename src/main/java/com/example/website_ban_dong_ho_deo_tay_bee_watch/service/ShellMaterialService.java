package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.ShellMaterial;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
@Service
public interface ShellMaterialService {
    ArrayList<ShellMaterial> getAll();
    ShellMaterial add(ShellMaterial shellMaterial);
    void delete(UUID id);
    ShellMaterial update(UUID id, ShellMaterial shellMaterial);
}
