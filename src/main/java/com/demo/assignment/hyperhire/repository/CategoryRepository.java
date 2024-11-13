package com.demo.assignment.hyperhire.repository;

import com.demo.assignment.hyperhire.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {

    List<Category> findAllByStatusOrderByPositionAsc(String status);
}
