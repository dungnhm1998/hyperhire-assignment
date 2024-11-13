package com.demo.assignment.hyperhire.model.dto;

import com.demo.assignment.hyperhire.model.entity.Mockup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MockupDto {

    private String id;
    private String url;
    private String type;

    public static MockupDto fromEntity(Mockup entity) {
        return MockupDto.builder()
                .id(entity.getId())
                .url(entity.getUrl())
                .type(entity.getType())
                .build();
    }

    public static List<MockupDto> fromEntities(List<Mockup> entities) {

        return entities.stream().map(MockupDto::fromEntity).collect(Collectors.toList());

    }
}
