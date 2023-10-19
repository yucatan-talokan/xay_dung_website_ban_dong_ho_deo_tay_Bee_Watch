package com.example.website_ban_dong_ho_deo_tay_bee_watch.controller;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.CaseMaterial;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.CaseMaterialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/caseMaterial")
public class CaseMaterialController {
    @Autowired
    CaseMaterialService caseMaterialService;
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<CaseMaterial>> listAll() {
        List<CaseMaterial> list = caseMaterialService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CaseMaterial>>(list, HttpStatus.OK);
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CaseMaterial save(@Valid @RequestBody CaseMaterial caseMaterial) {
        return caseMaterialService.add(caseMaterial);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CaseMaterial> deleteContact(@PathVariable(value = "id") UUID id) {
        caseMaterialService.delete(id);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CaseMaterial> updateById(@PathVariable UUID id, @RequestBody CaseMaterial caseMaterial) {
        CaseMaterial caseMaterialup = caseMaterialService.update(id, caseMaterial);
        if (caseMaterialup != null) {
            return ResponseEntity.ok(caseMaterialup);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
