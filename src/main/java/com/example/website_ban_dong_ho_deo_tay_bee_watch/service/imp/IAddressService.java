package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IAddressService {
    List<Address> findAll();

    Page<Address> findPage(Pageable pageable);

    Address findById(UUID id);

    Address save(Address account);

    void delete(UUID id);
}
