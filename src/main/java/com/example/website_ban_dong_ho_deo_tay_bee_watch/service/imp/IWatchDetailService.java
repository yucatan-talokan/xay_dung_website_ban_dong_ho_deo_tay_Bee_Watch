package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Account;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.WatchDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IWatchDetailService {
    List<WatchDetail> findAll();

    Page<WatchDetail> findPage(Pageable pageable);

    WatchDetail findById(UUID id);

    WatchDetail save(WatchDetail watchDetail);

    void delete(UUID id);

    List<WatchDetail>findWatchDetailByProductNameOrProductCode(String keyword);
}
