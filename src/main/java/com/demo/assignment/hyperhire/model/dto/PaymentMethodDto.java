package com.demo.assignment.hyperhire.model.dto;

import com.demo.assignment.hyperhire.model.entity.Mockup;
import com.demo.assignment.hyperhire.model.entity.Payment;
import com.demo.assignment.hyperhire.model.entity.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

}
