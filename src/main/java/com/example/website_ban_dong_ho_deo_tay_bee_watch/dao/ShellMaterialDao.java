package com.example.demo.DAO;

import com.example.demo.entity.ShellMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShellMaterialDao extends JpaRepository<ShellMaterial, UUID> {
}
