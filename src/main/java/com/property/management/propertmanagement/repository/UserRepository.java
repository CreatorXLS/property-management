package com.property.management.propertmanagement.repository;

import com.property.management.propertmanagement.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
