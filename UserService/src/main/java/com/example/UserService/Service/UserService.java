package com.example.UserService.Service;

import com.example.UserService.Entity.User;
import com.example.UserService.Repository.UserRepository;

import org.apache.http.protocol.HTTP;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;




    public void addUser(String username,String password){
        userRepository.save(new User(username,password));

    }

    public  boolean findUser(String username){
      if (userRepository.findUserByUsername(username) !=null){
          return true;
      }else {
          return false;
      }
    }
public ResponseEntity authorization(String username, String password){
    if(userRepository.authorization(username) == null || !userRepository.authorization(username).equals(password)){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }else {
        return  ResponseEntity.ok("Logged in");
    }
}
}
