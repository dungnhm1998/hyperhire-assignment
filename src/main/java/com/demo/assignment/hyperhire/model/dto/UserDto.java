package com.demo.assignment.hyperhire.model.dto;

import com.demo.assignment.hyperhire.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String email;
    private String name;

    public static UserDto fromEntity(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .name(entity.getName())
                .build();
    }
}
