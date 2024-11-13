package com.demo.assignment.hyperhire.repository;

import com.demo.assignment.hyperhire.model.entity.Category;
import com.demo.assignment.hyperhire.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {


    List<Category> findAllByStatusOrderByPositionAsc(String status);
}
