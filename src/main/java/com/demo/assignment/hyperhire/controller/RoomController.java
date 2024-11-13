package com.demo.assignment.hyperhire.controller;

import com.demo.assignment.hyperhire.model.dto.RoomDto;
import com.demo.assignment.hyperhire.model.dto.SearchDto;
import com.demo.assignment.hyperhire.model.response.Pagination;
import com.demo.assignment.hyperhire.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping()
    public Pagination<RoomDto> searchRooms(@RequestParam(name = "category_id", required = true) String categoryId,
                                           @RequestParam(name = "keyword", required = false) String keyword,
                                           @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                           @RequestParam(name = "page_size", required = false, defaultValue = "10") int pageSize) {
        SearchDto searchDto = SearchDto.builder()
                .categoryId(categoryId)
                .keyword(keyword)
                .page(page)
                .pageSize(pageSize)
                .build();
        return roomService.searchRooms(searchDto);
    }

    @GetMapping("/{id}")
    public RoomDto getRoomDetail(@PathVariable(name = "id") Long id) {
        return roomService.getRoomDetail(id);
    }

}
