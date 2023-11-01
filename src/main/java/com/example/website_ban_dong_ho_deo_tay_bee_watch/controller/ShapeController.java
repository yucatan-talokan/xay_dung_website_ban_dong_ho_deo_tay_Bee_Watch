package com.example.website_ban_dong_ho_deo_tay_bee_watch.controller;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Shape;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.ShapeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/shape")
public class ShapeController {
    @Autowired
    ShapeService shapeService;
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Shape>> listAll() {
        List<Shape> list = shapeService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Shape>>(list, HttpStatus.OK);
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Shape save(@Valid @RequestBody Shape shape) {
        return shapeService.add(shape);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Shape> deleteContact(@PathVariable(value = "id") UUID id) {
        shapeService.delete(id);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Shape> updateById(@PathVariable UUID id, @RequestBody Shape shape) {
        Shape updatedShape = shapeService.update(id, shape);
        if (updatedShape != null) {
            return ResponseEntity.ok(updatedShape);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}