package com.example.website_ban_dong_ho_deo_tay_bee_watch.service;

import com.example.website_ban_dong_ho_deo_tay_bee_watch.dao.IAccountDao;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.entity.Account;
import com.example.website_ban_dong_ho_deo_tay_bee_watch.service.imp.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountDao dao;

    @Override
    public List<Account> findAll() {
        return dao.findAll();
    }

    @Override
    public Page<Account> findPage(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public Account findById(UUID id) {
        Optional<Account>result = dao.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        else {
            throw new RuntimeException("Account id does not exist: Id= " + id);
        }
    }

    @Override
    public Account save(Account account) {
        return dao.save(account);
    }

    @Override
    public void delete(UUID id) {
        dao.deleteById(id);
    }
}
