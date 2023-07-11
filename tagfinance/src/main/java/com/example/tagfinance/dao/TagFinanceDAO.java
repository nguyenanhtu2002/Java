package com.example.tagfinance.dao;

import com.example.tagfinance.data.entity.TagFinance;

import java.util.List;

public interface TagFinanceDAO {
    void insertTagFinance(TagFinance tagFinance);

    List<TagFinance> getTagFinanceList();

    void updateTagFinance(TagFinance tagFinance, int id);

    void deleteTagFinance(int id);
}

