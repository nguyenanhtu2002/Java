package com.example.tagfinance.dao;

import com.example.tagfinance.data.entity.Transaction;

import java.util.List;

public interface Search {
    List<Transaction> searchTransactionByTagFinance(int id);
    List<Transaction> searchTransactionByTagFinanceName(String key);
}
