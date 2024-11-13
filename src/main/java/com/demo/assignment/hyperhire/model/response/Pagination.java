package com.demo.assignment.hyperhire.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Pagination<T> {

    @JsonProperty(value = "page")
    @JsonInclude(value = Include.NON_NULL)
    private Integer page;

    @JsonProperty(value = "page_size")
    @JsonInclude(value = Include.NON_NULL)
    private Integer pageSize;

    @JsonProperty(value = "total")
    @JsonInclude(value = Include.NON_NULL)
    private Long total;

    @JsonProperty(value = "result")
    private List<T> result;

    public Pagination(Integer page, Integer pageSize, Long total, List<T> result) {
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
        this.result = result;
    }
}
