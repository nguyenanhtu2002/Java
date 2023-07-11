package com.example.demo.dao;

import com.example.demo.data.entity.Transactions;

import java.util.List;

public interface TransactionDAO {
    List<Transactions> getAllTransactions();

    Transactions insertTransaction(Transactions transaction);

    Transactions updateTransaction(Transactions transaction, int id) ;

    void deleteTransaction(int id);

}
