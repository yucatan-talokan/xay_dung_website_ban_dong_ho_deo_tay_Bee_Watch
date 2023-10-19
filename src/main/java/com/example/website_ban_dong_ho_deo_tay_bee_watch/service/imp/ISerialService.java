package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Serial;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Size;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;

import java.util.ArrayList;
import java.util.UUID;

public interface ISerialService {
    ArrayList<Serial> getAll();
    Serial add(Serial serial);
    void delete(UUID id);
    Serial update(UUID id, Serial serial);
    Serial findById(UUID id);
}
