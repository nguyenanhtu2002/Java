package com.example.tagfinance.controller;

import com.example.tagfinance.data.dto.response.TagFinanceResponseDTO;
import com.example.tagfinance.data.entity.TagFinance;
import com.example.tagfinance.service.TagFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tagfinances")
public class TagFinanceController {
    @Autowired
    private TagFinanceService tagFinanceService;


    @GetMapping("/get")
    public List<TagFinanceResponseDTO> getAll() {
        List<TagFinanceResponseDTO> list = tagFinanceService.getAll();
        return list;
    }


    @PostMapping("/create")
    public TagFinance create(@RequestBody TagFinance tagFinance) {
        tagFinanceService.insert(tagFinance);
        return tagFinance;
    }

    @PutMapping("/{id}/update")
    public void updateTagFinance(@RequestBody TagFinance tagFinance, @PathVariable(name = "id") int id) {
        tagFinanceService.update(tagFinance, id);

    }

    @DeleteMapping("/{id}/delete")
    public void deleteTagFinance(@PathVariable(name = "id") int id) {
        tagFinanceService.delete(id);
    }


}
