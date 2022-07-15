package com.property.management.propertmanagement.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String ownerName;
    private String ownerEmail;
    private String phone;
    private String password;
}
