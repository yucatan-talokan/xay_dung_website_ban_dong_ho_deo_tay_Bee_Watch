package com.example.website_ban_dong_ho_deo_tay_bee_watch.dao;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Origin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IOriginDao extends JpaRepository<Origin, UUID> {
}
