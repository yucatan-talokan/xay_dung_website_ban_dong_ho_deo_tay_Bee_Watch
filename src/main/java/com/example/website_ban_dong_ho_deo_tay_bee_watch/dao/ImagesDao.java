package com.example.demo.DAO;

import com.example.demo.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImagesDao extends JpaRepository<Images, UUID> {
}
