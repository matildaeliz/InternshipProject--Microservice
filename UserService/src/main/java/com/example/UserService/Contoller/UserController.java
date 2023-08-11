package com.example.UserService.Contoller;

import com.example.UserService.Entity.User;

import com.example.UserService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;


@GetMapping("/register")
ResponseEntity addUser(@RequestParam("username") String username,@RequestParam("password") String password) {
    if(userService.findUser(username)){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }else {
        userService.addUser(username, password);
        return ResponseEntity.ok("User added succesfully");
    }

}

@GetMapping("/login")
ResponseEntity authorization(@RequestParam("username") String username,@RequestParam("password") String password){
    return userService.authorization(username,password);
}

}
