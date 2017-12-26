package com.chieftain.agency.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.chieftain.agency.entity.AccessToken;
import com.chieftain.agency.entity.User;

public interface UserService extends UserDetailsService {
	User findUserByAccessToken(String accessToken);

	AccessToken createAccessToken(User user);
}
