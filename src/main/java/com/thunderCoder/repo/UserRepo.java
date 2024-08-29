package com.thunderCoder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.thunderCoder.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{

	Users findByUsername(String username);

}
