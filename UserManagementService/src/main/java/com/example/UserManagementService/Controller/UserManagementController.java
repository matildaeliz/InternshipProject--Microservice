package com.example.UserManagementService.Controller;

import com.example.UserManagementService.Service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usermanagement")
public class UserManagementController {
    @Autowired
    UserManagementService userManagementService;

    @GetMapping("/deleteaccount")
    ResponseEntity deleteAccount(@RequestParam("username") String username){
       return userManagementService.deleteAccount(username);
    }
    @GetMapping("/changepassword")
    ResponseEntity changePassword(@RequestParam("username")String username, @RequestParam("password")String password){
       return userManagementService.changePassword(username,password);
    }
}
