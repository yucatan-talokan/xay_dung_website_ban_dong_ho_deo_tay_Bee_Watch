package com.example.website_ban_dong_ho_deo_tay_bee_watch.config;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.ShellColor;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.ShellColorService;
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
@RequestMapping("/shellColor")
public class ShellColorController {
    @Autowired
    ShellColorService shellColorService;
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<ShellColor>> listAll() {
        List<ShellColor> list = shellColorService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ShellColor>>(list, HttpStatus.OK);
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ShellColor save(@Valid @RequestBody ShellColor shellColor) {
        return shellColorService.add(shellColor);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ShellColor> deleteContact(@PathVariable(value = "id") UUID id) {
        shellColorService.delete(id);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ShellColor> updateStrapById(@PathVariable UUID id, @RequestBody ShellColor shellColor) {
        ShellColor updatedShellColor = shellColorService.update(id, shellColor);
        if (updatedShellColor != null) {
            return ResponseEntity.ok(updatedShellColor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
