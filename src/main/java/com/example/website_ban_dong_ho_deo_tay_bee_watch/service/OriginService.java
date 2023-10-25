package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.IOriginDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Origin;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.IOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public class OriginService implements IOriginService {
    @Autowired
    IOriginDao originDao;
    @Override
    public ArrayList<Origin> getAll() {
        return (ArrayList<Origin>) originDao.findAll();
    }

    @Override
    public Origin add(Origin origin) {
        return originDao.save(origin);
    }

    @Override
    public void delete(UUID id) {
        originDao.deleteById(id);
    }

    @Override
    public Origin update(UUID id, Origin origin) {
        Optional<Origin> optional = originDao.findById(id);
        if (optional.isPresent()){
            Origin origin1 = optional.get();
            origin1.setCode(origin.getCode());
            origin1.setName(origin.getName());
            originDao.save(origin1);
            return origin1;
        }
        return null;
    }
    @Override
    public Origin findById(UUID id) {
        Optional<Origin> optionalOrigin = originDao.findById(id);
        if (optionalOrigin.isPresent()) {
            return optionalOrigin.get();
        }else {
            System.out.printf("Not found Strap with id:" + id);
        }
        return null;
    }
}
