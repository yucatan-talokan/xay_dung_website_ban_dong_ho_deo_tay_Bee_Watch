package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.ShellColor;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
@Service
public interface ShellColorService{
    ArrayList<ShellColor> getAll();
    ShellColor add(ShellColor shellColor);
    void delete(UUID id);
    ShellColor update(UUID id, ShellColor shellColor);
}
