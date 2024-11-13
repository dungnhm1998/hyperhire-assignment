package com.demo.assignment.hyperhire.service;

import com.demo.assignment.hyperhire.model.dto.CategoryDto;
import com.demo.assignment.hyperhire.model.dto.RoomDto;
import com.demo.assignment.hyperhire.model.dto.SearchDto;
import com.demo.assignment.hyperhire.model.response.Pagination;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoomService {

    public Pagination<RoomDto> searchRooms(SearchDto searchDto);

    public RoomDto getRoomDetail(Long id);
}
