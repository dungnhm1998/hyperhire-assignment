package com.demo.assignment.hyperhire.repository;

import com.demo.assignment.hyperhire.model.dto.SearchDto;
import com.demo.assignment.hyperhire.model.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(nativeQuery = true,
            value = "SELECT  room.*" +
                    "FROM room " +
                    "WHERE room.category_Id = :#{#searchDto.categoryId}" +
                    "   AND (trim(:#{#searchDto.keyword}) is not null or room.name like '%'|| :#{#searchDto.keyword} || '%' )" +
                    "   AND room.status <> 'deleted'" +
                    "\n",
            countQuery = "SELECT  count(*)\n" +
                    "FROM room " +
                    "WHERE room.category_Id = :#{#searchDto.categoryId}" +
                    "   AND (trim(:#{#searchDto.keyword}) is not null or room.name like '%'|| :#{#searchDto.keyword} || '%' )" +
                    "   AND room.status <> 'deleted'" +
                    "\n")
    Page<Room> searchRooms(SearchDto searchDto, Pageable pageable);
}
