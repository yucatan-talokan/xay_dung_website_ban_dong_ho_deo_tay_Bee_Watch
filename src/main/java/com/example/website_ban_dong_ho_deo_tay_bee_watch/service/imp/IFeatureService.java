package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Feature;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;

import java.util.ArrayList;
import java.util.UUID;

public interface IFeatureService {
    ArrayList<Feature> getAll();
    Feature add(Feature feature);
    void delete(UUID id);
    Feature update(UUID id, Feature feature);
    Feature findById(UUID id);
}
