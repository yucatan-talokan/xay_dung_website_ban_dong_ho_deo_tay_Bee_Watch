package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product>findAll();

    Product save (Product p);
}
