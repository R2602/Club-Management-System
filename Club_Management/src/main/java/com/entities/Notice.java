package com.entities;

public class Notice {
	  private int clubId;
	    private int notice_id;
	    private String noticeName;
	    private String noticeDescription;
	    private String noticeDate;
		public Notice(int notice_id, int clubId, String noticeName,String noticeDate, String noticeDescription) {
	        this.setNotice_id(notice_id);
	        this.setClubId(clubId);
	        this.setNoticeName(noticeName);
	        this.setNoticeDate(noticeDate);
	        this.setNoticeDescription(noticeDescription);
		}

		public int getClubId() {
			return clubId;
		}

		public void setClubId(int clubId) {
			this.clubId = clubId;
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
