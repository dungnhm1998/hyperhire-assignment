package com.demo.assignment.hyperhire.model.dto;

import com.demo.assignment.hyperhire.model.entity.Room;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class RoomDto {

    private Long id;
    private String name;
    private String state;
    private String country;
    @JsonProperty(value = "interior_bed")
    private Integer interiorBed;
    @JsonProperty(value = "interior_room")
    private Integer interiorRoom;
    @JsonProperty(value = "interior_bathroom")
    private Integer interiorBathroom;
    @JsonProperty(value = "point")
    private String point;
    @JsonProperty(value = "price")
    private String price;
    private String currency;
    @JsonProperty(value = "owner")
    private String owner;
    @JsonProperty(value = "short_desc")
    private String shortDesc;
    @JsonProperty(value = "long_desc")
    private String longDesc;
    private String rule;
    private String category_id;
    private String type;
    private String status;
    @JsonProperty(value = "create_at")
    private Date createAt;
    @JsonProperty(value = "update_at")
    private Date updateAt;

    //more detail info
    private List<MockupDto> mockupDtos;

    public static RoomDto fromEntity(Room entity) {
        return RoomDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .state(entity.getState())
                .country(entity.getCountry())
                .interiorBed(entity.getInteriorBed())
                .interiorRoom(entity.getInteriorRoom())
                .interiorBathroom(entity.getInteriorBathroom())
                .point(entity.getPoint())
                .price(entity.getPrice())
                .currency(entity.getCurrency())
                .owner(entity.getOwner())
                .shortDesc(entity.getShortDesc())
                .longDesc(entity.getLongDesc())
                .rule(entity.getRule())
                .category_id(entity.getCategory_id())
                .type(entity.getType())
                .status(entity.getStatus())
                .createAt(new Date(entity.getCreateAt().getTime()))
                .updateAt(entity.getUpdateAt() != null ? new Date(entity.getUpdateAt().getTime()): null)
                .build();
    }

    public static List<RoomDto> fromEntities(List<Room> entities) {
        return entities.stream().map(RoomDto::fromEntity).collect(Collectors.toList());
    }
}
