package com.mirrordev.crudapptemplate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mirrordev.crudapptemplate.model.User;
import com.mirrordev.crudapptemplate.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<User> getListUsers(){
        return userRepository.findAll();
    }


    public Optional<User> getUser(Long id) {
        return userRepository.findById(id) ;
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public void createUser(User user) {
        userRepository.saveAndFlush(user);
    }


    public void updateUser(User updatedUser, Long id) throws Exception {
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()){
            User userToUpd = existingUser.get();
            userToUpd.setName(updatedUser.getName());
            userToUpd.setEmail(updatedUser.getEmail());
            userToUpd.setPassword(updatedUser.getPassword());
            userToUpd.setCreatedAt(updatedUser.getCreatedAt());

            userRepository.save(userToUpd);
        }
    }


  
}   
