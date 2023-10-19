package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Origin;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;

import java.util.ArrayList;
import java.util.UUID;

public interface IOriginService {
    ArrayList<Origin> getAll();
    Origin add(Origin origin);
    void delete(UUID id);
    Origin update(UUID id, Origin origin);
    Origin findById(UUID id);
}
