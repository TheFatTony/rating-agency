package com.chieftain.agency.dao.accesstoken;

import com.chieftain.agency.dao.Dao;
import com.chieftain.agency.entity.AccessToken;

public interface AccessTokenDao extends Dao<AccessToken, Long>
{
    AccessToken findByToken(String accessTokenString);
}
