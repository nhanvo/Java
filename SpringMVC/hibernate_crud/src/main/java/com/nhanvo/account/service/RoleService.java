package com.nhanvo.account.service;

import com.nhanvo.account.model.Role;

public interface RoleService {
	void save(Role role);
	Role getRoleById(Long i);
}
