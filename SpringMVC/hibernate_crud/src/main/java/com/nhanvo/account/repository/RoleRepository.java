package com.nhanvo.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhanvo.account.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
