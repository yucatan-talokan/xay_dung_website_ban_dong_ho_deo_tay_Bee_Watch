package com.example.website_ban_dong_ho_deo_tay_bee_watch.controller;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.CaseColor;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.CaseColorService;
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
@RequestMapping("/shellColor")
public class CaseColorController {
    @Autowired
    CaseColorService caseColorService;
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<CaseColor>> listAll() {
        List<CaseColor> list = caseColorService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CaseColor>>(list, HttpStatus.OK);
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CaseColor save(@Valid @RequestBody CaseColor caseColor) {
        return caseColorService.add(caseColor);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CaseColor> deleteContact(@PathVariable(value = "id") UUID id) {
        caseColorService.delete(id);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CaseColor> updateById(@PathVariable UUID id, @RequestBody CaseColor caseColor) {
        CaseColor updatedCaseColor = caseColorService.update(id, caseColor);
        if (updatedCaseColor != null) {
            return ResponseEntity.ok(updatedCaseColor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
