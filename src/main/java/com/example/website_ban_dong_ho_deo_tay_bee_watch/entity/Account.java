package com.example.website_ban_dong_ho_deo_tay_bee_watch.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_address",referencedColumnName = "id")
    private Address address;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "update_date")
    private Date updatedDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "accountroles",
            joinColumns = @JoinColumn(name = "id_account"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Collection<Role> roles;

}
