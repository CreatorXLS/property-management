package com.property.management.propertmanagement.service;

import com.property.management.propertmanagement.converter.UserConverter;
import com.property.management.propertmanagement.dto.UserDTO;
import com.property.management.propertmanagement.entity.UserEntity;
import com.property.management.propertmanagement.exception.BusinessException;
import com.property.management.propertmanagement.exception.ErrorModel;
import com.property.management.propertmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {

        Optional<UserEntity> optUe = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());

        if(optUe.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Email Already Exist");
            errorModel.setMessage("User with this email already exist");

            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
            UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
            userEntity = userRepository.save(userEntity);
            userDTO = userConverter.convertEntityToDTO(userEntity);
            return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        Optional<UserEntity> optionalUserEntity =  userRepository.findByOwnerEmailAndPassword(email, password);
        UserDTO userDTO = null;
        if(optionalUserEntity.isPresent()){
            userDTO = userConverter.convertEntityToDTO(optionalUserEntity.get());
        }else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Invalid Login credentials");
            errorModel.setMessage("Incorrect Email or Password");

            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        return userDTO;
    }
}
