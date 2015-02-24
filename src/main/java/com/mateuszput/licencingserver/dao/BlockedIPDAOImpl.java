package com.mateuszput.licencingserver.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

//TODO: dodac implementacje
public class BlockedIPDAOImpl extends HibernateDaoSupport implements BlockedIPDAO{

	public void addBlockedIP(String blockedIP) {
		// TODO Auto-generated method stub
		
	}

	public Boolean isBlocked(String ipToCheck) {
		// TODO Auto-generated method stub
		return false;
	}

}
