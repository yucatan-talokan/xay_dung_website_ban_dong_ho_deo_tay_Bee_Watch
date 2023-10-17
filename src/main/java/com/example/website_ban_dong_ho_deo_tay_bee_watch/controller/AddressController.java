package com.example.website_ban_dong_ho_deo_tay_bee_watch.controller;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Account;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Address;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/findPage/{page}")
    public ResponseEntity<?> findPage(@PathVariable Integer page) {
        if (page == 0) page = 1;
        Pageable pageable= PageRequest.of(page-1,5);
        List<Address> list=addressService.findPage(pageable).getContent();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<?>save(@RequestBody Address address){
        return ResponseEntity.ok(addressService.save(address));
    }

    @PutMapping()
    public ResponseEntity<?>update(@RequestBody Address address){
        return ResponseEntity.ok(addressService.save(address));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        addressService.delete(id);
    }
}
