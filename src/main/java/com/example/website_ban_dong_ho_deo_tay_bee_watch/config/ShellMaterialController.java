package com.example.website_ban_dong_ho_deo_tay_bee_watch.config;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Strap;
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
@RequestMapping("/strap")
public class ShellMaterialController {
    @Autowired
    StrapServiceIpml strapService;
    @RequestMapping(value = "/new/", method = RequestMethod.GET)
    public ResponseEntity<List<Strap>> listAll() {
        List<Strap> list = strapService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Strap>>(list, HttpStatus.OK);
    }
    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public Strap save(@Valid @RequestBody Strap strap) {
        return strapService.add(strap);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Strap> deleteContact(@PathVariable(value = "id") UUID id) {
        strapService.delete(id);
        return ResponseEntity.ok().build();
    }
}
