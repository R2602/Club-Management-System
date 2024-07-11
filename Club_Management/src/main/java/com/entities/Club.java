package com.entities;

public class Club {
    private int clubId;
    private String clubName;
    private String description;
    private int foundedYear;  
    private int memberId;
    private int userId; 
    private String Email;
    private int blog_Id;
    private String blogName;
    private String blogDescription;
    private int notice_id;
    private String noticeName;
    private String noticeDate;
    private String noticeDescription;


	
	public void Blog(int blog_id, int clubId, String blogName, String blogDescription) {
        this.setBlog_Id(blog_Id);
        this.setClubId(clubId);
        this.setBlogName(blogName);
        this.setBlogDescription(blogDescription);
	}
	public void Notice(int notice_id, int clubId, String noticeName,String noticeDate, String noticeDescription) {
        this.setNotice_id(notice_id);
        this.setClubId(clubId);
        this.setNoticeName(noticeName);
        this.setNoticeDate(noticeDate);
        this.setNoticeDescription(noticeDescription);
	}
	
	public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getFoundedYear() {
		return foundedYear;
	}
	public void setFoundedYear(int foundedYear) {
		this.foundedYear = foundedYear;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getBlog_Id() {
		return blog_Id;
	}

	public void setBlog_Id(int blog_Id) {
		this.blog_Id = blog_Id;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogDescription() {
		return blogDescription;
	}

	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}

	public int getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}

	public String getNoticeName() {
		return noticeName;
	}

	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}

	public String getNoticeDescription() {
		return noticeDescription;
	}

	public void setNoticeDescription(String noticeDescription) {
		this.noticeDescription = noticeDescription;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
}


