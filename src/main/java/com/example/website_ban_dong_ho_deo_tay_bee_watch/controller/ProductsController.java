package com.example.website_ban_dong_ho_deo_tay_bee_watch.controller;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Origin;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Product;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.OriginService;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.ProductsService;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.StrapService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProductsController {
    @Autowired
    ProductsService productsService;
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAll() {
        List<Product> list = productsService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Product save(@Valid @RequestBody Product product) {
        return productsService.add(product);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteContact(@PathVariable(value = "id") UUID id) {
        productsService.delete(id);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateById(@PathVariable UUID id, @RequestBody Product product) {
        Product updated = productsService.update(id, product);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(productsService.findById(id));
    }
}

