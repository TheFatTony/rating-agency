package com.chieftain.agency.dao.user;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.chieftain.agency.dao.Dao;
import com.chieftain.agency.entity.User;

public interface UserDao extends Dao<User, Long>
{
    User loadUserByUsername(String username) throws UsernameNotFoundException;

    User findByName(String name);
}
