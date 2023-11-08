package com.example.website_ban_dong_ho_deo_tay_bee_watch.dao;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Feature;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface IFeatureDao extends JpaRepository<Feature, UUID> {
    @Query(value = "INSERT INTO Features (code, name, created_date) values (?, ?, GetDate())", nativeQuery = true)
    Feature add(Feature feature);
}
