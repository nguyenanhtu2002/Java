package com.example.tagfinance.data.dto.request;

import com.example.tagfinance.data.entity.TagFinance;
import com.example.tagfinance.data.entity.Transaction;

public class TransactionRequestDTO {
    private String title;
    private String description;
    private int amount;
    private int tagID;


    public TransactionRequestDTO(String title, String description, int amount, int tagID) {
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.tagID = tagID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public int getTagID() {
        return tagID;
    }

    public void setTagID(int tagID) {
        this.tagID = tagID;
    }
}
