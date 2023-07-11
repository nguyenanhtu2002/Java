package com.example.tagfinance.dao;

import com.example.tagfinance.data.entity.Transaction;

import java.util.List;

public interface TransactionDAO {
    void insertTransaction(String title, String description, int amount, int tagID);

    void updateTransaction(String title, String description, int amount, int tagID, int id);

    void deleteTransaction(int id);

    List<Transaction> getTransactionList();
}
