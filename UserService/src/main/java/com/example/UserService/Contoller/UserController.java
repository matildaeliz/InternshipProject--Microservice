package com.example.UserService.Contoller;

import com.example.UserService.Entity.User;
import com.example.UserService.Response.UserResponse;
import com.example.UserService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;



@PostMapping("/register")
ResponseEntity<String> addUser(@RequestParam String username,@RequestParam String password) {
    userService.addUser(username, password);
    return ResponseEntity.ok("User added succesfully");
}

}
