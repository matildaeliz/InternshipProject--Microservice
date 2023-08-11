package com.example.UserManagementService.Repository;

import com.example.UserManagementService.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserManagementRepository extends JpaRepository<User,String> {
    @Modifying
    @Transactional
    @Query("DELETE  FROM User user  WHERE user.username=:username")
    void deleteUser(@Param("username") String username);

    @Modifying
    @Transactional
    @Query("UPDATE User user SET user.password =:password WHERE user.username=:username")
    void changePassword(@Param("username") String username, @Param("password") String password);

    @Query("SELECT user.username FROM User user WHERE user.username=:username")
    String existsUserByUsername(@Param("username") String username);
}
