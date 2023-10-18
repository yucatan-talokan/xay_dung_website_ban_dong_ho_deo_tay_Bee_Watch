package com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IAccountService {
    List<Account> findAll();

    Page<Account>findPage(Pageable pageable);

    Account findById(UUID id);

    Account save(Account account);

    void delete(UUID id);

}
