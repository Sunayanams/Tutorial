package com.niit.musicmainee.Dao;

import java.util.List;

import com.niit.musicmainee.entity.UserDetails;

public interface UserDetailsDao 
{
   public boolean save(UserDetails userdetails);
//   public boolean update(UserDetails userdetails);
   public boolean delete(String id);
   public UserDetails get(String user_id);
   public UserDetails getName(String E_id);
   public List<UserDetails> list();
   public UserDetails isvalidate(String email_id,String password);
}
