package com.nhanvo.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhanvo.account.model.Role;
import com.nhanvo.account.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
    private RoleRepository roleRepository;

	@Override
	public void save(Role role) {
		roleRepository.save(role);	
	}

	@Override
	public Role getRoleById(Long id) {
		Role role = roleRepository.findOne(id);
		if (role == null)
			return new Role("USER");
		
		return role;
	}
}
