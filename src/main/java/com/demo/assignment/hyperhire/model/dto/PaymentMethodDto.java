package com.demo.assignment.hyperhire.model.dto;

import com.demo.assignment.hyperhire.model.entity.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentMethodDto {

    private String id;
    private String method;
    private String name;

    public static PaymentMethodDto fromEntity(PaymentMethod entity) {
        return PaymentMethodDto.builder()
                .id(entity.getId())
                .method(entity.getMethod())
                .name(entity.getName())
                .build();
    }

    public static List<PaymentMethodDto> fromEntities(List<PaymentMethod> entities) {
        return entities.stream().map(PaymentMethodDto::fromEntity).collect(Collectors.toList());
    }

}
