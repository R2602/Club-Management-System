package com.entities;

public class UserInfo {
    private int userId;
    private String username;
    private boolean isHeadUser;
    private String email;

    public UserInfo(int userId, String username, boolean isHeadUser, String email) {
        this.setUserId(userId);
        this.setUsername(username);
        this.setHeadUser(isHeadUser);
        this.setEmail(email);
    }

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

	public boolean isHeadUser() {
		return isHeadUser;
	}

	public void setHeadUser(boolean isHeadUser) {
		this.isHeadUser = isHeadUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
