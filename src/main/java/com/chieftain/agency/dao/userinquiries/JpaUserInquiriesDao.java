package com.chieftain.agency.dao.userinquiries;

import com.chieftain.agency.dao.JpaDao;
import com.chieftain.agency.entity.UserInquiries;

public class JpaUserInquiriesDao extends JpaDao<UserInquiries, Long> implements UserInquiriesDao {
	public JpaUserInquiriesDao() {
		super(UserInquiries.class);
	}


}
