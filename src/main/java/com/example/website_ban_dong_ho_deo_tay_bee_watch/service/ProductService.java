package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.IProductDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Product;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductDao dao;

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public Product save(Product p) {
        return dao.save(p);
    }
}
