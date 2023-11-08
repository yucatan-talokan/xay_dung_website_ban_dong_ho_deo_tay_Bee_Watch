package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.IProductsDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Origin;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Product;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
@Service
public class ProductsService implements IProductsService {
    @Autowired
    IProductsDao   iProductsDao;
    @Override
    public ArrayList<Product> getAll() {
        return (ArrayList<Product>) iProductsDao.findAll();
    }

    @Override
    public Product add(Product product) {
        return iProductsDao.save(product);
    }

    @Override
    public void delete(UUID id) {
        iProductsDao.deleteById(id);
    }

    @Override
    public Product update(UUID id, Product product) {
        Optional<Product> optional = iProductsDao.findById(id);
        if (optional.isPresent()){
            Product product1 = optional.get();
            product1.setCode(product.getCode());
            product1.setName(product.getName());
            iProductsDao.save(product);
            return product1;
        }
        return null;
    }

    @Override
    public Product findById(UUID id) {
        Optional<Product> optional = iProductsDao.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }else {
            System.out.printf("Not found Product with id:" + id);
        }
        return null;
    }
}
