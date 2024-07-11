package com.entities;

public class Feedback {
    private int clubId;
    private String name;
    private String feedbackText;
	
    public Feedback(String name,String feedbackText) {
        this.setName(name);
        this.setClubId(clubId);
        this.setFeedbackText(feedbackText);
   	}
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFeedbackText() {
		return feedbackText;
	}
	public void setFeedbackText(String feedbackText) {
		this.feedbackText = feedbackText;
	}

}

