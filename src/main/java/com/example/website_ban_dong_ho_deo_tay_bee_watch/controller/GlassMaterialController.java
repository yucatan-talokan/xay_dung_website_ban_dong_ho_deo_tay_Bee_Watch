package com.example.website_ban_dong_ho_deo_tay_bee_watch.controller;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.GlassMaterial;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.GlassMaterialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin("*")
@RestController
@RequestMapping("/glassMaterial")
public class GlassMaterialController {
    @Autowired
    GlassMaterialService glassMaterialService;
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<GlassMaterial>> listAll() {
        List<GlassMaterial> list = glassMaterialService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<GlassMaterial>>(list, HttpStatus.OK);
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public GlassMaterial save(@Valid @RequestBody GlassMaterial glassMaterial) {
        return glassMaterialService.add(glassMaterial);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<GlassMaterial> deleteContact(@PathVariable(value = "id") UUID id) {
        glassMaterialService.delete(id);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<GlassMaterial> updateById(@PathVariable UUID id, @RequestBody GlassMaterial glassMaterial) {
        GlassMaterial updatedGlass = glassMaterialService.update(id, glassMaterial);
        if (updatedGlass != null) {
            return ResponseEntity.ok(updatedGlass);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
