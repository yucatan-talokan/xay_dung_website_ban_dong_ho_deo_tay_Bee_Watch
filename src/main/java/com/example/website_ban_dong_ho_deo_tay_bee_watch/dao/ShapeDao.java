package com.example.demo.DAO;

import com.example.demo.entity.Shape;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShapeDao extends JpaRepository<Shape, UUID> {
}
