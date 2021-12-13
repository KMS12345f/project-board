package model;

import java.util.Date;

public class FreeBoardDTO {
	
	private int fnum;
	private String title;
	private String content;
	private String writer;
	private int viewCount;
	private Date regDate2;
	
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public Date getRegDate2() {
		return regDate2;
	}
	public void setRegDate2(Date regDate2) {
		this.regDate2 = regDate2;
	}
	
	
	public FreeBoardDTO(int fnum) {
		super();
		this.fnum = fnum;
	}
	
	public FreeBoardDTO() {
		
	}

	@Override
	public String toString() {
		return "FreeBoardDTO [fnum=" + fnum + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", viewCount=" + viewCount + ", regDate2=" + regDate2 + "]";
	}

	public FreeBoardDTO(int fnum, String title, String content, String writer, int viewCount, Date regDate2) {
		super();
		this.fnum = fnum;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.viewCount = viewCount;
		this.regDate2 = regDate2;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
	
	
	
	
	
	
	
	
}
