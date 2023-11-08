package com.example.website_ban_dong_ho_deo_tay_bee_watch.controller;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.MachineType;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.MachineService;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.StrapService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/machineType")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class MachineController {
    @Autowired
    MachineService machineService;
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<MachineType>> listAll() {
        List<MachineType> list = machineService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<MachineType>>(list, HttpStatus.OK);
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public MachineType save(@Valid @RequestBody MachineType machineType) {
        return machineService.add(machineType);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<MachineType> deleteContact(@PathVariable(value = "id") UUID id) {
        machineService.delete(id);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MachineType> updateById(@PathVariable UUID id, @RequestBody MachineType machineType) {
        MachineType updated = machineService.update(id, machineType);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(machineService.findById(id));
    }
}
