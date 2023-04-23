package com.orient.springcrud.service.impl;

import com.orient.springcrud.model.Account;
import com.orient.springcrud.repository.AccountRepository;
import com.orient.springcrud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public List<Account> findAll() {
        List<Account> accounts = accountRepository.findAll();

        return accounts;
    }

    @Override
    public Account findById(Long id) {
        Account account = null;

        try {
            account = accountRepository.findById(id).get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return account;
    }

    @Override
    public void create(Account account) {

        accountRepository.save(account);

    }

    @Override
    public void update(Long id, Account account) {
        Account oldAccount = findById(id);
        oldAccount.setFirstName(account.getFirstName());
        oldAccount.setLastName(account.getLastName());
        oldAccount.setEmail(account.getEmail());
        oldAccount.setUserName(account.getUserName());
        oldAccount.setPassword(account.getPassword());

        accountRepository.save(oldAccount);
    }

    @Override
    public void delete(Long id) {
        Account account = findById(id);
        if (account != null) {
            accountRepository.delete(account);
        }


    }
}
