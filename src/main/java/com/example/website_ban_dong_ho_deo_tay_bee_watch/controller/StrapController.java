package com.example.website_ban_dong_ho_deo_tay_bee_watch.controller;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.StrapService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/strap")
public class StrapController {
    @Autowired
    StrapService strapService;
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Strap>> listAll() {
        List<Strap> list = strapService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Strap>>(list, HttpStatus.OK);
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Strap save(@Valid @RequestBody Strap strap) {
        return strapService.add(strap);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Strap> deleteContact(@PathVariable(value = "id") UUID id) {
        strapService.delete(id);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Strap> updateStrapById(@PathVariable UUID id, @RequestBody Strap strap) {
        Strap updatedStrap = strapService.update(id, strap);
        if (updatedStrap != null) {
            return ResponseEntity.ok(updatedStrap);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(strapService.findById(id));
    }
}
