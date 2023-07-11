package com.example.tagfinance.data.dto.response;

import com.example.tagfinance.data.entity.Transaction;

public class TransactionResponseDTO {
    private String title;
    private String description;
    private int amount;
    private String name;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TransactionResponseDTO(String title, String description, int amount, String name) {
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.name = name;
    }

    public TransactionResponseDTO(Transaction transaction) {

        this.title = transaction.getTitle();
        this.description = transaction.getDescription();
        this.amount = transaction.getAmount();
        this.name = transaction.getTagFinance().getName();
    }

}
