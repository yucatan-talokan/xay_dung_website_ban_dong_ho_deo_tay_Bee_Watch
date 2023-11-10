package com.example.website_ban_dong_ho_deo_tay_bee_watch.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;

    @Column(name = "code")
    private String code;

    @Column(name = "total_money")
    private BigDecimal totalMoney;

    @Column(name = "total_payment")
    private BigDecimal totalPayment;

    @Column(name = "date_payment")
    private Date datePayment;

    @Column(name = "shipping_price")
    private BigDecimal shippingPrice;

    @Column(name = "shipping_date")
    private Date shippingDate;

    @Column(name = "received_date")
    private Date receivedDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "create_date")
    private Date createdDate;

    @Column(name = "update_date")
    private Date updatedDate;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "is_deleted")
    private Boolean isDeleted;


}
