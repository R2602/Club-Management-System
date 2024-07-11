package com.entities;

public class User {
    private int userId;
    private String username;
    private String email;
    private String password;
    private boolean isHeadUser; // 
    private boolean isAdmin;

    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isHeadUser() {
		return isHeadUser;
	}
	public void setHeadUser(boolean isHeadUser) {
		this.isHeadUser = isHeadUser;
	}
    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
	public String getJoinedClubName() {
		// TODO Auto-generated method stub
		return null;
	}
    
	public class UserClubInfo {
	    private int userId;
	    private int clubId;

	    public UserClubInfo(int userId, int clubId) {
	        this.userId = userId;
	        this.clubId = clubId;
	    }

	    public int getUserId() {
	        return userId;
	    }

	    public int getClubId() {
	        return clubId;
	    }
	}

}
