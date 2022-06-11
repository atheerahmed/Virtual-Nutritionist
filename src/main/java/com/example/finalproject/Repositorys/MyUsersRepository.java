package com.example.finalproject.Repositorys;

import com.example.finalproject.Models.MyUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUsersRepository extends JpaRepository<MyUsers,Integer> {
    MyUsers findUsersByUsername(String username);
}
