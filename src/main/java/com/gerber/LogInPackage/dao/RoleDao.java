package com.gerber.LogInPackage.dao;


import com.gerber.LogInPackage.entity.Role;

import java.util.List;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	public List<Role> getAllRoles();
	
}
