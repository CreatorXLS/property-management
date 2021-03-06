package com.property.management.propertmanagement.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PROPERTY_TABLE")
@Data
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String address;

}
