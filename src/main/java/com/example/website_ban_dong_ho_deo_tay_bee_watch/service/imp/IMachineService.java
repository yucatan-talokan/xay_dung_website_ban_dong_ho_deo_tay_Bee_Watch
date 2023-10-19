package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.MachineType;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;

import java.util.ArrayList;
import java.util.UUID;

public interface IMachineService {
    ArrayList<MachineType> getAll();
    MachineType add(MachineType machineType);
    void delete(UUID id);
    MachineType update(UUID id, MachineType machineType);
    MachineType findById(UUID id);
}
