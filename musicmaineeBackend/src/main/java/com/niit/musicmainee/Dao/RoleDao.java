package com.niit.musicmainee.Dao;

import java.util.List;

import com.niit.musicmainee.entity.CategoryDetails;
import com.niit.musicmainee.entity.Role;

public interface RoleDao 
{
	  public boolean save(Role role);
	  public boolean delete(String role_id);
	  public Role get(String role_id);
	  public List<Role> list(); 
}
