package com.example.myfirstProject.controller;

import com.example.myfirstProject.entity.JournalEntry;
import com.example.myfirstProject.entity.User;
import com.example.myfirstProject.service.JournalEntryService;
import com.example.myfirstProject.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User>  getAllUser(){
           return userService.getAll();
    }
    @PostMapping
    public void createUser(@RequestBody User user){
        userService.saveEntry(user);
    }
    @PutMapping("/{userName}")
    public ResponseEntity<?>  updateUser(@RequestBody User user , @PathVariable String userName){
        User userInDb = userService.findByUserName(userName);
        if(userInDb !=  null){
            userInDb.setUserName(user. getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
