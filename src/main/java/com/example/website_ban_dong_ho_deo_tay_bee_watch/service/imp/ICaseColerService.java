package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.CaseColorDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.CaseColor;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.CaseColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public interface ICaseColerService {
    ArrayList<CaseColor> getAll();
    CaseColor add(CaseColor caseColor);
    void delete(UUID id);
    CaseColor update(UUID id, CaseColor caseColor);
    CaseColor findById(UUID id);
}
