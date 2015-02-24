package com.mateuszput.licencingserver.dao;

public interface BlockedIPDAO {
//	public List<BlockedIP> getAll(); 
	public void addBlockedIP(String blockedIP);
	public Boolean isBlocked(String ipToCheck);
}
