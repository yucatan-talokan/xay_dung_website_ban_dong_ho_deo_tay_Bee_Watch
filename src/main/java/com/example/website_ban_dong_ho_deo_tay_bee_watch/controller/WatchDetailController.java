package com.example.website_ban_dong_ho_deo_tay_bee_watch.controller;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Account;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.WatchDetail;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.IWatchDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/watch_detail")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class WatchDetailController {
    @Autowired
    private IWatchDetailService watchDetailService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(watchDetailService.findAll());
    }

    @GetMapping("/findPage/{page}")
    public ResponseEntity<?> findPage(@PathVariable Integer page) {
        if (page == 0) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 5);
        List<WatchDetail> list = watchDetailService.findPage(pageable).getContent();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(watchDetailService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody WatchDetail watchDetail) {
        return ResponseEntity.ok(watchDetailService.save(watchDetail));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody WatchDetail watchDetail) {
        return ResponseEntity.ok(watchDetailService.save(watchDetail));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        watchDetailService.delete(id);
    }
}
