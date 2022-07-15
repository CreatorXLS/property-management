package com.property.management.propertmanagement.service;

import com.property.management.propertmanagement.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);

    UserDTO login(String email, String password);
}
