package com.example.UserManagementService.Service;

import com.example.UserManagementService.Repository.UserManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {
    @Autowired
    UserManagementRepository userManagementRepository;

   public ResponseEntity deleteAccount(String username){

       if(userManagementRepository.existsUserByUsername(username) == null){
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       }else{
           userManagementRepository.deleteUser(username);

           return ResponseEntity.status(HttpStatus.OK).build();
       }

    }

   public ResponseEntity changePassword(String username, String password){
     if(userManagementRepository.existsUserByUsername(username) == null){
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
     }else {
         userManagementRepository.changePassword(username,password);
         return ResponseEntity.status(HttpStatus.OK).build();
     }

    }
}
