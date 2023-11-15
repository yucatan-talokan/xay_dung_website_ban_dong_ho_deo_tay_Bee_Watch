package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.IWatchDetailDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.WatchDetail;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.IWatchDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WatchDetailService implements IWatchDetailService {
    @Autowired
    private IWatchDetailDao dao;

    @Override
    public List<WatchDetail> findAll() {
        return dao.findAll();
    }

    @Override
    public Page<WatchDetail> findPage(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public WatchDetail findById(UUID id) {
        Optional<WatchDetail>result = dao.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        else {
            throw new RuntimeException("WatchDetail id does not exist: Id= " + id);
        }
    }

    @Override
    public WatchDetail save(WatchDetail watchDetail) {
        return dao.save(watchDetail);
    }

    @Override
    public void delete(UUID id) {
        dao.deleteById(id);
    }

    @Override
    public List<WatchDetail> findWatchDetailByProductNameOrProductCode(String keyword) {
        return dao.findWatchDetailByProductNameOrProductCode(keyword);
    }
}
