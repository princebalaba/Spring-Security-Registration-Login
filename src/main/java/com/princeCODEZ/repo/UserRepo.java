package com.princeCODEZ.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.princeCODEZ.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmail(String email);

}
