package com.example.demo.service.implement;

import com.example.demo.constant.MessageResponse;
import com.example.demo.dao.TagFinanceDAO;
import com.example.demo.data.dto.Request.TagfinanceRequestDTO;
import com.example.demo.data.dto.Response.BaseResponse;
import com.example.demo.data.dto.Response.TagFinanceResponseDTO;
import com.example.demo.data.entity.TagFinance;
import com.example.demo.service.TagFinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagFinanceServiceImpl implements TagFinanceService {
    private final TagFinanceDAO tagFinanceDAO;


    @Override
    public BaseResponse createTag(TagfinanceRequestDTO tagfinanceRequestDTO) throws Exception {
        TagFinance tagReqest = new TagFinance(tagfinanceRequestDTO);
        return new BaseResponse(MessageResponse.Tag_Information,
                new TagFinanceResponseDTO(tagFinanceDAO.createTagFinance(tagReqest)));
    }

    @Override
    public BaseResponse updateTag(TagfinanceRequestDTO tagfinanceRequestDTO, int Id) throws Exception {
        TagFinance tagUpdate = new TagFinance(tagfinanceRequestDTO);
        tagFinanceDAO.updateTagFinance(tagUpdate, Id);
        return new BaseResponse(MessageResponse.SUCCESS);
    }

    @Override
    public BaseResponse deleteTag(TagfinanceRequestDTO tagfinanceRequestDTO, int Id) throws Exception {
        tagFinanceDAO.deleteTagFinance(Id);
        return new BaseResponse(MessageResponse.SUCCESS);
    }

    @Override
    public BaseResponse getAllTagFinance() throws Exception {
        List<TagFinance> listTagFinance = tagFinanceDAO.getAllTagFinance();
        return new BaseResponse(MessageResponse.SUCCESS, (TagFinanceResponseDTO) listTagFinance);
    }

    @Override
    public TagFinance getTagFinanceById(int id) throws Exception {
        return tagFinanceDAO.getTagFinanceById(id);
    }
}