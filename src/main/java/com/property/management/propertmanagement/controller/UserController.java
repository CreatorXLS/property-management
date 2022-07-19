package com.property.management.propertmanagement.controller;

import com.property.management.propertmanagement.dto.UserDTO;
import com.property.management.propertmanagement.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "register", notes = "this method is used for user registration")
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO userDTO){
        userDTO = userService.register(userDTO);

        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@Valid @RequestBody UserDTO userDTO){
        userDTO = userService.login(userDTO.getOwnerEmail(), userDTO.getPassword());

        return new ResponseEntity<>(userDTO, HttpStatus.OK);

    }


}
