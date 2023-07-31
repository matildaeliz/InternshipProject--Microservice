package com.example.UserService.Service;

import com.example.UserService.Entity.User;
import com.example.UserService.Repository.UserRepository;
import com.example.UserService.Response.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public UserResponse getEmployee(int id){
        User user = userRepository.findById(id).get();
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user,userResponse);
        return userResponse;
    }


    public void addUser(String username,String password){
        userRepository.save(new User(username,password));
        System.out.println("arda");
    }
}
