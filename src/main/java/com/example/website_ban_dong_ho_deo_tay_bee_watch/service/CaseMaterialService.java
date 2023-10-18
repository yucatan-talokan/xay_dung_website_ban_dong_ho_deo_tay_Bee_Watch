package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.CaseMaterial;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
@Service
public interface CaseMaterialService {
    ArrayList<CaseMaterial> getAll();
    CaseMaterial add(CaseMaterial caseMaterial);
    void delete(UUID id);
    CaseMaterial update(UUID id, CaseMaterial caseMaterial);
}
