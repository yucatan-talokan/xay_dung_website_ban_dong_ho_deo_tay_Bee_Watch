package com.example.demo.DAO;

import com.example.demo.entity.Strap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StrapDao extends JpaRepository<Strap, UUID> {
}
