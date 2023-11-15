package com.example.website_ban_dong_ho_deo_tay_bee_watch.dao;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.WatchDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IWatchDetailDao extends JpaRepository<WatchDetail, UUID> {
    @Query("select w from WatchDetail w where w.product.name like :keyword or w.product.code like :keyword")
    List<WatchDetail>findWatchDetailByProductNameOrProductCode(@Param("keyword")String keyword);
}
