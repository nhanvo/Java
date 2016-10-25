package com.nhanvo.account.repository;

import com.nhanvo.account.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
