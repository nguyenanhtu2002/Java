package com.example.tagfinance.service.impl;

import com.example.tagfinance.dao.Search;
import com.example.tagfinance.dao.TagFinanceDAO;
import com.example.tagfinance.dao.TransactionDAO;
import com.example.tagfinance.dao.impl.TagFinanceDAOImpl;
import com.example.tagfinance.dao.impl.TransactionDAOImpl;
import com.example.tagfinance.data.dto.response.TransactionResponseDTO;
import com.example.tagfinance.data.dto.request.TransactionRequestDTO;
import com.example.tagfinance.data.entity.Transaction;
import com.example.tagfinance.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService {
    private final Search search = new TransactionDAOImpl();
    private final TransactionDAO transactionDAO = new TransactionDAOImpl();
    public static List<TransactionResponseDTO> transactionDTOS = new ArrayList<>();
    private final TagFinanceDAO tagFinanceDAO=new TagFinanceDAOImpl();

    @Override
    public void insert(TransactionRequestDTO transaction) {
        transactionDAO.insertTransaction(transaction.getTitle(),transaction.getDescription()
                ,transaction.getAmount(),transaction.getTagID());

    }

    @Override
    public List<TransactionResponseDTO> getAll() {
        List<Transaction> transactionList = transactionDAO.getTransactionList();
        for (int i = 0; i < transactionList.size(); i++) {
            TransactionResponseDTO transactionDTO = new TransactionResponseDTO(transactionList.get(i));
            transactionDTOS.add(transactionDTO);
        }
        return transactionDTOS;
    }

    @Override
    public void update(TransactionRequestDTO transactionRequestDTO, int id) {
        transactionDAO.updateTransaction(transactionRequestDTO.getTitle(),transactionRequestDTO.getDescription(),
                transactionRequestDTO.getAmount(),transactionRequestDTO.getTagID(), id);


    }

    @Override
    public void delete(int id) {
        transactionDAO.deleteTransaction(id);

    }

    @Override
    public List<TransactionResponseDTO> getTransactionByID(int id) {
        List<Transaction> transactionList = search.searchTransactionByTagFinance(id);
        for (int i = 0; i < transactionList.size(); i++) {
            TransactionResponseDTO transactionDTO = new TransactionResponseDTO(transactionList.get(i));
            transactionDTOS.add(transactionDTO);
        }
        return transactionDTOS;
    }

    @Override
    public List<TransactionResponseDTO> getTransactionByName(String key) {
        List<Transaction> transactionList = search.searchTransactionByTagFinanceName(key);
        for (int i = 0; i < transactionList.size(); i++) {
            TransactionResponseDTO transactionDTO = new TransactionResponseDTO(transactionList.get(i));
            transactionDTOS.add(transactionDTO);
        }
        return transactionDTOS;
    }
}
