package com.demo.assignment.hyperhire.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchDto {

    private String categoryId;

    private String keyword;
    private String country;

    private String orderBy;
    private String orderDirection;

    int page;
    int pageSize;

}
