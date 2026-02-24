package com.vishnu.online_banking_system.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.vishnu.online_banking_system.repository.AccountRepository;
import com.vishnu.online_banking_system.entity.Account;
import java.util.List;
import java.util.Optional;
import com.vishnu.online_banking_system.entity.Account;
import com.vishnu.online_banking_system.exception.AccountNotFoundException;
import com.vishnu.online_banking_system.exception.InsufficientBalanceException;
import com.vishnu.online_banking_system.entity.User;
import com.vishnu.online_banking_system.repository.UserRepository;
import com.vishnu.online_banking_system.entity.Transaction;
import com.vishnu.online_banking_system.repository.TransactionRepository;
import java.time.LocalDateTime;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    
    public void deposit(Long accountId, double amount) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Account not found with id: " + accountId));

        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setType("DEPOSIT");
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setAccount(account);

        transactionRepository.save(transaction);
    }


    
    public void withdraw(Long accountId, double amount) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Account not found with id: " + accountId));

        if (account.getBalance() < amount) {
            throw new InsufficientBalanceException(
                    "Insufficient balance. Available balance: " + account.getBalance());
        }

        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setType("WITHDRAW");
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setAccount(account);

        transactionRepository.save(transaction);
    }




    public void transfer(Long fromAccountId, Long toAccountId, double amount) {

        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "From account not found with id: " + fromAccountId));

        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "To account not found with id: " + toAccountId));

        if (fromAccount.getBalance() < amount) {
            throw new InsufficientBalanceException(
                    "Insufficient balance in source account. Available balance: "
                            + fromAccount.getBalance());
        }

        // update balances
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        // DEBIT transaction (from account)
        Transaction debitTxn = new Transaction();
        debitTxn.setType("TRANSFER_DEBIT");
        debitTxn.setAmount(amount);
        debitTxn.setTimestamp(LocalDateTime.now());
        debitTxn.setAccount(fromAccount);
        transactionRepository.save(debitTxn);

        // CREDIT transaction (to account)
        Transaction creditTxn = new Transaction();
        creditTxn.setType("TRANSFER_CREDIT");
        creditTxn.setAmount(amount);
        creditTxn.setTimestamp(LocalDateTime.now());
        creditTxn.setAccount(toAccount);
        transactionRepository.save(creditTxn);
    }



    
    @Autowired
    private UserRepository userRepository;


    public void createAccountForUser(Long userId, Account account) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "User not found with id: " + userId));

        account.setUser(user);
        accountRepository.save(account);
    }


    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getTransactionsByAccount(Long accountId) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Account not found with id: " + accountId));

        return transactionRepository.findByAccount(account);
    }

}
