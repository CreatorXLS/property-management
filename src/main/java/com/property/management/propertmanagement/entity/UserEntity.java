package com.property.management.propertmanagement.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USER_TABLE")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ownerName;
    private String ownerEmail;
    private String phone;
    private String password;
}
