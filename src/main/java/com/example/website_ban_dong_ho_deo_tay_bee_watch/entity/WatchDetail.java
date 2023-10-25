package com.example.website_ban_dong_ho_deo_tay_bee_watch.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "watchdetails")
public class WatchDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_brand",referencedColumnName = "id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "id_serial",referencedColumnName = "id")
    private Serial serial;

    @ManyToOne
    @JoinColumn(name = "id_machine_type",referencedColumnName = "id")
    private MachineType machineType;

    @ManyToOne
    @JoinColumn(name = "id_gender",referencedColumnName = "id")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "id_strap",referencedColumnName = "id")
    private Strap strap;

    @ManyToOne
    @JoinColumn(name = "id_glass_material",referencedColumnName = "id")
    private GlassMaterial glassMaterial;

    @ManyToOne
    @JoinColumn(name = "id_feature",referencedColumnName = "id")
    private Feature feature;

    @ManyToOne
    @JoinColumn(name = "id_size",referencedColumnName = "id")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "id_origin",referencedColumnName = "id")
    private Origin origin;

    @ManyToOne
    @JoinColumn(name = "id_case_material",referencedColumnName = "id")
    private CaseMaterial caseMaterial;

    @ManyToOne
    @JoinColumn(name = "id_case_color",referencedColumnName = "id")
    private CaseColor caseColor;

    @ManyToOne
    @JoinColumn(name = "id_shape",referencedColumnName = "id")
    private Shape shape;

    @ManyToOne
    @JoinColumn(name = "id_product",referencedColumnName = "id")
    private Product product;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity_stock")
    private BigInteger quantityStock;

    @Column(name = "description")
    private String description;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "update_date")
    private Date updatedDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "status")
    private Boolean status;
}
