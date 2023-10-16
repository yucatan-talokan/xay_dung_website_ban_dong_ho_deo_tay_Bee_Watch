package com.example.website_ban_dong_ho_deo_tay_bee_watch.config;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.ShellMaterial;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.ShellMaterialService;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.StrapServiceIpml;
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
@RequestMapping("/shellMaterial")
public class ShellMaterialController {
    @Autowired
    ShellMaterialService shellMaterialService;
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<ShellMaterial>> listAll() {
        List<ShellMaterial> list = shellMaterialService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ShellMaterial>>(list, HttpStatus.OK);
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ShellMaterial save(@Valid @RequestBody ShellMaterial shellMaterial) {
        return shellMaterialService.add(shellMaterial);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ShellMaterial> deleteContact(@PathVariable(value = "id") UUID id) {
        shellMaterialService.delete(id);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ShellMaterial> updateStrapById(@PathVariable UUID id, @RequestBody ShellMaterial shellMaterial) {
        ShellMaterial shellMaterialup = shellMaterialService.update(id, shellMaterial);
        if (shellMaterialup != null) {
            return ResponseEntity.ok(shellMaterialup);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
