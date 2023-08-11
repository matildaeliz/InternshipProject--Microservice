package com.example.UserService.Repository;

import com.example.UserService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,String> {

    @Query("SELECT user.username FROM User user  WHERE user.username =:username ")
  String findUserByUsername(@Param("username")String username);

    @Query("SELECT user.password FROM User user WHERE user.username =:username")
    String authorization(@Param("username") String username);
}
