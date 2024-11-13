package com.demo.assignment.hyperhire.service.impl;

import com.demo.assignment.hyperhire.model.dto.MockupDto;
import com.demo.assignment.hyperhire.model.dto.RoomDto;
import com.demo.assignment.hyperhire.model.dto.SearchDto;
import com.demo.assignment.hyperhire.model.entity.Mockup;
import com.demo.assignment.hyperhire.model.entity.Room;
import com.demo.assignment.hyperhire.model.exception.BadRequestException;
import com.demo.assignment.hyperhire.model.exception.ServerError;
import com.demo.assignment.hyperhire.model.response.Pagination;
import com.demo.assignment.hyperhire.repository.MockupRepository;
import com.demo.assignment.hyperhire.repository.RoomRepository;
import com.demo.assignment.hyperhire.service.RoomService;
import com.demo.assignment.hyperhire.util.StatePool;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final MockupRepository mockupRepository;

    @Override
    public Pagination<RoomDto> searchRooms(SearchDto searchDto) {

        Pageable pageable = PageRequest.of(searchDto.getPage() - 1, searchDto.getPageSize());

        Page<Room> rooms = roomRepository.searchRooms(searchDto, pageable);

        List<RoomDto> listRoomDto = RoomDto.fromEntities(rooms.getContent());

        return new Pagination<>(searchDto.getPage(), searchDto.getPageSize(), rooms.getTotalElements(), listRoomDto);
    }

    @Override
    public RoomDto getRoomDetail(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new BadRequestException(ServerError.NOT_FOUND_ROOM));
        RoomDto roomDto = RoomDto.fromEntity(room);

        List<Mockup> mockups = mockupRepository.findAllByRoomId(roomDto.getId());
        List<MockupDto> mockupDtos = MockupDto.fromEntities(mockups);

        roomDto.setMockupDtos(mockupDtos);

        return roomDto;
    }

}
