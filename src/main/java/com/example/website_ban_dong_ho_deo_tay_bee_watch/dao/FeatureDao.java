package com.example.website_ban_dong_ho_deo_tay_bee_watch.dao;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Feature;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeatureDao extends JpaRepository<Feature, UUID> {
}