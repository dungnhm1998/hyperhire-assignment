package com.demo.assignment.hyperhire.repository;

import com.demo.assignment.hyperhire.model.entity.Mockup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MockupRepository extends JpaRepository<Mockup, String> {

    List<Mockup> findAllByRoomId(Long roomId);
}
