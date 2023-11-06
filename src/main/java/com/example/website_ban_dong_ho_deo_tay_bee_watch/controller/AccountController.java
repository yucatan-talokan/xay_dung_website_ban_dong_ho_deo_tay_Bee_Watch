package com.example.website_ban_dong_ho_deo_tay_bee_watch.controller;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Account;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin("*")
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(accountService.findAll());
    }

    @GetMapping("/findPage/{page}")
    public ResponseEntity<?> findPage(@PathVariable Integer page) {
        if (page == 0) page = 1;
        Pageable pageable= PageRequest.of(page-1,5);
        List<Account>list=accountService.findPage(pageable).getContent();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(accountService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<?>save(@RequestBody Account account){
        return ResponseEntity.ok(accountService.save(account));
    }

    @PutMapping()
    public ResponseEntity<?>update(@RequestBody Account account){
        return ResponseEntity.ok(accountService.save(account));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        accountService.delete(id);
    }
}
