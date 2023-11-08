package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Origin;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Product;

import java.util.ArrayList;
import java.util.UUID;

public interface IProductsService{
    ArrayList<Product> getAll();
    Product add(Product product);
    void delete(UUID id);
    Product update(UUID id, Product product);
    Product findById(UUID id);
}
