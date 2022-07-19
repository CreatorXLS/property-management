package com.property.management.propertmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private Long id;
    private String ownerName;
    @NotNull(message = "Owner Email is mandatory")
    @NotEmpty(message = "field cannot be empty")
    @Size(min = 1, max = 50, message = "Owner Email should be between 6 to 50 characters long")
    private String ownerEmail;
    private String phone;
    @NotNull(message = "password cannot be empty")
    @NotEmpty(message = "field cannot be empty")
    private String password;
}
