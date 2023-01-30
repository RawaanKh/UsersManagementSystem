package com.example.usersmangementswe.Controller;

import com.example.usersmangementswe.Model.User;
import com.example.usersmangementswe.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping ("/api/v1/usersManegment")

public class UserController {
    final private UserService userService;
    @GetMapping("/get")
    public ResponseEntity getUser(){
        List<User> users = userService.getUser();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors error){
        if(error.hasErrors()){
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody User user, Errors error, @PathVariable Integer id) {
        if (error.hasErrors()) {
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
        }
        boolean isValid = userService.updateUser(id, user);
        if (isValid) {
            return ResponseEntity.status(200).body("user is updated ");
        }
        return ResponseEntity.status(400).body("Id is not found");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        boolean isValid = userService.deleteUser(id);
        if(isValid){
            return ResponseEntity.status(200).body("user is deleted ");
        }
        return ResponseEntity.status(400).body("Id is not found");

    }
}
