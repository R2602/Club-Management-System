package com.entities;

public class UserClub {
	private int user_id;
	private int clubId;
    private String clubName;
    private String clubDescription;
    private int clubYear; 
    

	public int getClubId() {
		return clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getClubDescription() {
		return clubDescription;
	}

	public void setClubDescription(String clubDescription) {
		this.clubDescription = clubDescription;
	}

	public int getClubYear() {
		return clubYear;
	}

	public void setClubYear(int clubYear) {
		this.clubYear = clubYear;
	}

    public UserClub(int clubId, String clubName, String clubDescription, int clubYear) {
        this.setClubYear(clubYear);
        this.setClubId(clubId);
        this.setClubName(clubName);
        this.setClubDescription(clubDescription);
	}

	

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	
}
	
