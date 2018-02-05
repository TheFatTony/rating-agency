package com.chieftain.agency.dao.user;

import com.chieftain.agency.dao.Dao;
import com.chieftain.agency.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDao extends Dao<User, Long>
{
    User loadUserByUsername(String username) throws UsernameNotFoundException;

    User findByName(String name);
}
