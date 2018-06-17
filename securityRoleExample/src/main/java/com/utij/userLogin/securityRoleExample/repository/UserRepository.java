package com.utij.userLogin.securityRoleExample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utij.userLogin.securityRoleExample.model.Users;

public interface UserRepository extends JpaRepository<Users, String> {

	Optional<Users> findbyName(String userName);

	
}
