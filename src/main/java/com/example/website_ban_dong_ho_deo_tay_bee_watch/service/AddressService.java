package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.IAddressDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Address;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private IAddressDao dao;

    @Override
    public List<Address> findAll() {
        return dao.findAll();
    }

    @Override
    public Page<Address> findPage(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public Address findById(UUID id) {
        Optional<Address> result = dao.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Address id does not exist: Id= " + id);
        }
    }

    @Override
    public Address save(Address account) {
        return dao.save(account);
    }

    @Override
    public void delete(UUID id) {
        dao.deleteById(id);
    }
}
