package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.annotation.processing.Generated;
import java.util.UUID;

@Table(name = "GlassMaterial")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class GlassMaterial {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
}
