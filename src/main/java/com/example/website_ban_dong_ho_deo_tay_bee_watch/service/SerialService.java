package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.SerialDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.StrapDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Serial;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.ISerialService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class SerialService implements ISerialService {
    @Autowired
    SerialDao serialDao;
    @Override
    public ArrayList<Serial> getAll() {
        return (ArrayList<Serial>) serialDao.findAll();
    }

    @Override
    public Serial add(Serial serial) {
        return serialDao.save(serial);
    }

    @Override
    public void delete(UUID id) {
        serialDao.deleteById(id);
    }

    @Override
    public Serial update(UUID id, Serial serial) {
        Optional<Serial> optional = serialDao.findById(id);
        if (optional.isPresent()){
            Serial serial1 = optional.get();
            serial1.setCode(serial.getCode());
            serial1.setName(serial.getName());
            serialDao.save(serial1);
            return serial1;
        }
        return null;
    }
    @Override
    public Serial findById(UUID id) {
        Optional<Serial> serialOptional = serialDao.findById(id);
        if (serialOptional.isPresent()) {
            return serialOptional.get();
        }else {
            System.out.printf("Not found Strap with id:" + id);
        }
        return null;
    }
}
