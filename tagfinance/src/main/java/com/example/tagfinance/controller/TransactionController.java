package com.example.tagfinance.controller;

import com.example.tagfinance.data.dto.response.TransactionResponseDTO;
import com.example.tagfinance.data.dto.request.TransactionRequestDTO;
import com.example.tagfinance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/get")
    public List<TransactionResponseDTO> getAllTransaction() {
        List<TransactionResponseDTO> list = transactionService.getAll();
        return list;
    }

    @GetMapping("/{tag_id}/get")
    public List<TransactionResponseDTO> getTransactionByTagFinanceID(@PathVariable(name = "tag_id") int id) {
        List<TransactionResponseDTO> list = transactionService.getTransactionByID(id);
        return list;

    }




    @PutMapping("/{ID}/update")
    public void updateTransaction(@RequestBody TransactionRequestDTO transaction, @PathVariable(name = "ID") int id) {
        transactionService.update(transaction, id);
    }

    @PostMapping("/create")
    public TransactionRequestDTO createTransaction(@RequestBody TransactionRequestDTO transaction) {
        transactionService.insert(transaction);
        return transaction;
    }

    @DeleteMapping("/{id}/delete")
    public void deleteTransaction(@PathVariable(name = "id") int id) {

        transactionService.delete(id);
    }


}
