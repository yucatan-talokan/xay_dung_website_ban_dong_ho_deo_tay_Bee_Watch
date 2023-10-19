package com.example.website_ban_dong_ho_deo_tay_bee_watch.controller;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Size;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.SizeService;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.StrapService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/size")
public class SizeController {
    @Autowired
    SizeService sizeService;
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Size>> listAll() {
        List<Size> list = sizeService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Size>>(list, HttpStatus.OK);
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Size save(@Valid @RequestBody Size size) {
        return sizeService.add(size);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Size> deleteContact(@PathVariable(value = "id") UUID id) {
        sizeService.delete(id);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Size> updateById(@PathVariable UUID id, @RequestBody Size size) {
        Size updated = sizeService.update(id, size);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(sizeService.findById(id));
    }
}
