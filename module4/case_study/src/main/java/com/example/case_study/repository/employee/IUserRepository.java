package com.example.case_study.repository.employee;

import com.example.case_study.entity.Role;
import com.example.case_study.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserRepository extends JpaRepository<User,String> {
    User findByUsername(String username);

    @Query("select u.roles from User u where u.username = :username")
    List<Role> findAllRoleByUsername(String username);
}
