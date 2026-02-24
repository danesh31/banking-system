package com.vishnu.online_banking_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vishnu.online_banking_system.entity.Transaction;
import com.vishnu.online_banking_system.entity.Account;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAccount(Account account);
}
