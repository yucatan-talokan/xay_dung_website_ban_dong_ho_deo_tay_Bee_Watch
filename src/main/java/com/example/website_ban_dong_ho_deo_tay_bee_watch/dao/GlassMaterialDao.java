package com.example.demo.DAO;

import com.example.demo.entity.GlassMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GlassMaterialDao extends JpaRepository<GlassMaterial, UUID> {
}
