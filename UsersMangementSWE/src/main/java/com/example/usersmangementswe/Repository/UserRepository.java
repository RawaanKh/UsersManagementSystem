package com.example.usersmangementswe.Repository;

import com.example.usersmangementswe.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
