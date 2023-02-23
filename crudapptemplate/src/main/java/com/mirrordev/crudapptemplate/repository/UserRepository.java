package com.mirrordev.crudapptemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirrordev.crudapptemplate.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
