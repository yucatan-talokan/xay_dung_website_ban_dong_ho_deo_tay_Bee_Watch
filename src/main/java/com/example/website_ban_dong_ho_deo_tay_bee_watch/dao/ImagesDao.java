package com.example.website_ban_dong_ho_deo_tay_bee_watch.dao;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImagesDao extends JpaRepository<Images, UUID> {
}
