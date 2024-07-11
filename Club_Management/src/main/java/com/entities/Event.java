package com.entities;

public class Event {
    private int eventId;
    private int clubId;
    private String eventDate;
    private String eventDescription;


    public Event(int eventId, int clubId, String eventDate, String eventDescription) {
        this.setEventId(eventId);
        this.setClubId(clubId);
        this.setEventDate(eventDate);
        this.setEventDescription(eventDescription);
    }


	public int getEventId() {
		return eventId;
	}


	public void setEventId(int eventId) {
		this.eventId = eventId;
	}


	public int getClubId() {
		return clubId;
	}


	public void setClubId(int clubId) {
		this.clubId = clubId;
	}


	public String getEventDescription() {
		return eventDescription;
	}


	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}


	public String getEventDate() {
		return eventDate;
	}


	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

}