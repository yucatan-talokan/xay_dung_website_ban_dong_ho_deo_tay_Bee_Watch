package com.example.website_ban_dong_ho_deo_tay_bee_watch.dao;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.GlassMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IGlassMaterialDao extends JpaRepository<GlassMaterial, UUID> {
}
