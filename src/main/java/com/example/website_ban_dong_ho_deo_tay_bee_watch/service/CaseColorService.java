package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.CaseColor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
@Service
public interface CaseColorService {
    ArrayList<CaseColor> getAll();
    CaseColor add(CaseColor caseColor);
    void delete(UUID id);
    CaseColor update(UUID id, CaseColor caseColor);
}
