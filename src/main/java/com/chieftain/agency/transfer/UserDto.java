package com.chieftain.agency.transfer;

import java.util.Map;


public class UserDto
{

	private final String name;

	private final Map<String, Boolean> roles;


	public UserDto(String userName, Map<String, Boolean> roles)
	{
		this.name = userName;
		this.roles = roles;
	}


	public String getName()
	{
		return this.name;
	}


	public Map<String, Boolean> getRoles()
	{
		return this.roles;
	}

}