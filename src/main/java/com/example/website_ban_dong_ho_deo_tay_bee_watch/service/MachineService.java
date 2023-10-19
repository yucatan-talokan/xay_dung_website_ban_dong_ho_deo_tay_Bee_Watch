package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.MachineTypeDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.StrapDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.MachineType;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.IMachineService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class MachineService implements IMachineService {
    @Autowired
    MachineTypeDao machineTypeDao;
    @Override
    public ArrayList<MachineType> getAll() {
        return (ArrayList<MachineType>) machineTypeDao.findAll();
    }

    @Override
    public MachineType add(MachineType machineType) {
        return machineTypeDao.save(machineType);
    }

    @Override
    public void delete(UUID id) {
        machineTypeDao.deleteById(id);
    }

    @Override
    public MachineType update(UUID id, MachineType machineType) {
        Optional<MachineType> optional = machineTypeDao.findById(id);
        if (optional.isPresent()){
            MachineType machineType1 = optional.get();
            machineType1.setCode(machineType.getCode());
            machineType1.setName(machineType.getName());
            machineTypeDao.save(machineType1);
            return machineType1;
        }
        return null;
    }
    @Override
    public MachineType findById(UUID id) {
        Optional<MachineType> machineTypeOptional = machineTypeDao.findById(id);
        if (machineTypeOptional.isPresent()) {
            return machineTypeOptional.get();
        }else {
            System.out.printf("Not found Strap with id:" + id);
        }
        return null;
    }
}
