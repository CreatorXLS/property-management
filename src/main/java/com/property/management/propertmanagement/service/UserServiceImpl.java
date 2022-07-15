package com.property.management.propertmanagement.service;

import com.property.management.propertmanagement.dto.UserDTO;
import com.property.management.propertmanagement.entity.UserEntity;
import com.property.management.propertmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO register(UserDTO userDTO) {
        userRepository.save(new UserEntity());
        return null;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
