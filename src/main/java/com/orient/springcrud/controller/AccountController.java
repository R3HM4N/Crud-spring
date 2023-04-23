package com.orient.springcrud.controller;


import com.orient.springcrud.model.Account;

import com.orient.springcrud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping(value = "/all")
    public List<Account> findAll() {

        List<Account> accounts = accountService.findAll();
        return accounts;
    }

    @GetMapping(value = "/{id}")
    public Account findById(@PathVariable Long id) {
        Account account = accountService.findById(id);
        return account;
    }


    @PostMapping("/create")
    public void create(@RequestBody Account account) {

        accountService.create(account);
    }


    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable Long id, @RequestBody Account account) {

        accountService.update(id, account);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {

        accountService.delete(id);
    }

}
