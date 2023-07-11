package com.example.tagfinance.service;

import com.example.tagfinance.data.dto.response.TagFinanceResponseDTO;
import com.example.tagfinance.data.dto.response.TransactionResponseDTO;
import com.example.tagfinance.data.dto.request.TransactionRequestDTO;

import java.util.List;

public interface TransactionService {
    void insert(TransactionRequestDTO transactionRequestDTO);


    List<TransactionResponseDTO> getAll();

    void update(TransactionRequestDTO transactionRequestDTO, int id);

    void delete(int id);

    List<TransactionResponseDTO> getTransactionByID(int id);

    List<TransactionResponseDTO> getTransactionByName(String key);


}
