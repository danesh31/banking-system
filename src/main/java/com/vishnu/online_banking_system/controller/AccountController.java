package com.vishnu.online_banking_system.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.vishnu.online_banking_system.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.vishnu.online_banking_system.entity.Account;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.vishnu.online_banking_system.entity.Transaction;

@RestController
public class AccountController {
    // account APIs will come here
	@Autowired
	private AccountService accountService;

	@PostMapping("/accounts")
	public String createAccount(@RequestBody Account account) {
	    account.setBalance(0.0);
	    accountService.createAccount(account);
	    return "Account created successfully";
	}
	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
	    return accountService.getAllAccounts();
	}
	@PutMapping("/accounts/deposit")
	public String deposit(@RequestParam Long accountId,
	                      @RequestParam double amount) {

	    accountService.deposit(accountId, amount);
	    return "Amount deposited successfully";
	}


	@PutMapping("/accounts/withdraw")
	public String withdraw(@RequestParam Long accountId,
	                       @RequestParam double amount) {

	    accountService.withdraw(accountId, amount);
	    return "Amount withdrawn successfully";
	}

	@PutMapping("/accounts/transfer")
	public String transfer(@RequestParam Long fromAccountId,
	                       @RequestParam Long toAccountId,
	                       @RequestParam double amount) {

	    accountService.transfer(fromAccountId, toAccountId, amount);
	    return "Amount transferred successfully";
	}
	
	@PostMapping("/users/{userId}/accounts")
	public String createAccountForUser(@PathVariable Long userId,
	                                   @RequestBody Account account) {

	    account.setBalance(0.0);
	    accountService.createAccountForUser(userId, account);
	    return "Account created for user successfully";
	}

	@GetMapping("/accounts/{accountId}/transactions")
	public List<Transaction> getTransactionsByAccount(@PathVariable Long accountId) {
	    return accountService.getTransactionsByAccount(accountId);
	}



}
