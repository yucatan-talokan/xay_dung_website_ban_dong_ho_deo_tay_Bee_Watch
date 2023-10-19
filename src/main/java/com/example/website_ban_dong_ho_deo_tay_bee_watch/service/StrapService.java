package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.StrapDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.IStrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public class StrapService implements IStrapService {
        @Autowired
        StrapDao strapDao;
        @Override
        public ArrayList<Strap> getAll() {
                return (ArrayList<Strap>) strapDao.findAll();
        }

        @Override
        public Strap add(Strap strap) {
                return strapDao.save(strap);
        }

        @Override
        public void delete(UUID id) {
                strapDao.deleteById(id);
        }

        @Override
        public Strap update(UUID id, Strap strap) {
                Optional<Strap> optional = strapDao.findById(id);
                if (optional.isPresent()){
                        Strap strapOp = optional.get();
                        strapOp.setCode(strap.getCode());
                        strapOp.setName(strap.getName());
                        strapDao.save(strapOp);
                        return strapOp;
                }
                return null;
        }

        @Override
        public Strap findById(UUID id) {
                Optional<Strap> strapOptional = strapDao.findById(id);
                if (strapOptional.isPresent()) {
                        return strapOptional.get();
                }else {
                        System.out.printf("Not found Strap with id:" + id);
                }
                return null;
        }
}
