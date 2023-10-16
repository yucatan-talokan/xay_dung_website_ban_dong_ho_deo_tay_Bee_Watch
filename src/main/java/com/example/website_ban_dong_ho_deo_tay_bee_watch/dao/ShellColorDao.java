package com.example.demo.DAO;

import com.example.demo.entity.ShellColor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShellColorDao extends JpaRepository<ShellColor, UUID> {
}
