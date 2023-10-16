package com.example.website_ban_dong_ho_deo_tay_bee_watch.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "ShellMaterial")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class ShellMaterial {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
}
