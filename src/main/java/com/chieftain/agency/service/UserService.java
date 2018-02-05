package com.chieftain.agency.service;

import com.chieftain.agency.entity.AccessToken;
import com.chieftain.agency.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	User findUserByAccessToken(String accessToken);

	AccessToken createAccessToken(User user);
}
