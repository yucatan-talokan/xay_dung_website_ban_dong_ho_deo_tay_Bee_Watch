package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.FeatureDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.StrapDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Feature;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.IFeatureService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class FeatureService implements IFeatureService {
    @Autowired
    FeatureDao featureDao;
    @Override
    public ArrayList<Feature> getAll() {
        return (ArrayList<Feature>) featureDao.findAll();
    }

    @Override
    public Feature add(Feature feature) {
        return featureDao.save(feature);
    }

    @Override
    public void delete(UUID id) {
        featureDao.deleteById(id);
    }

    @Override
    public Feature update(UUID id, Feature feature) {
        Optional<Feature> optional = featureDao.findById(id);
        if (optional.isPresent()){
            Feature feature1 = optional.get();
            feature1.setCode(feature.getCode());
            feature1.setName(feature.getName());
            featureDao.save(feature1);
            return feature1;
        }
        return null;
    }

    public Feature findById(UUID id) {
        Optional<Feature> featureOptional = featureDao.findById(id);
        if (featureOptional.isPresent()) {
            return featureOptional.get();
        }else {
            System.out.printf("Not found Strap with id:" + id);
        }
        return null;
    }
}
