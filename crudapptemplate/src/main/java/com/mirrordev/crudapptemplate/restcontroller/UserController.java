package com.mirrordev.crudapptemplate.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.mirrordev.crudapptemplate.model.User;
import com.mirrordev.crudapptemplate.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/users")
@RequiredArgsConstructor
public class UserController {
    

    private final UserService userService;


    @RequestMapping(path = "/get-list-user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getListUsers(){
        List<User> listUser = userService.getListUsers();
        return ResponseEntity.ok(listUser);
    }

    
    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id) {
        Optional<User> user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }


    @RequestMapping(path = "/delete/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User id " + id + " was successfully deleted");
    }


    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.ok(user.getName() + " created successfully");
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updateUser) throws Exception {
        userService.updateUser(updateUser, id);
        return ResponseEntity.ok("updated successfully");
    }
}
