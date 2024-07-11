package com.entities;
public class ClubMember {
    private int memberId;
    private int clubId;
    private int userId;
    private String memberName;
    private String Email;
    
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}


    // Constructors, getters, and setters
}
