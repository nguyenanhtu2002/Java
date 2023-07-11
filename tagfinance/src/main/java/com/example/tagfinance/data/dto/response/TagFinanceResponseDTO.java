package com.example.tagfinance.data.dto.response;

import com.example.tagfinance.data.entity.TagFinance;

public class TagFinanceResponseDTO {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TagFinanceResponseDTO(TagFinance tagFinance) {
        this.id = tagFinance.getId();
        this.name = tagFinance.getName();
    }
}
