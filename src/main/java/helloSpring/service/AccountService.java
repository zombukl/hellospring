package helloSpring.service;


import helloSpring.controller.exception.AccountNotFoundException;
import helloSpring.entity.Account;
import helloSpring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long createAccount(String name, String email, Integer bill) {
        Account account = new Account(name, email, bill);
        accountRepository.save(account);
        return accountRepository.save(account).getId();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Are you sucking?"));
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Account deleteById(Long id) {
        Account account = getAccountById(id);
        accountRepository.deleteById(id);
        return account;
    }
}
