package model;

import java.util.Date;

public class CommentDTO {
	int cnum;
	int fnum;
	String comment;
	String writer;
	Date regDate3;
	
	public CommentDTO() {

	}

	public int getCnum() {
		return cnum;
	}

	public void setCnum(int cnum) {
		this.cnum = cnum;
	}

	public int getFnum() {
		return fnum;
	}

	public void setFnum(int fnum) {
		this.fnum = fnum;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegDate3() {
		return regDate3;
	}

	public void setRegDate3(Date regDate3) {
		this.regDate3 = regDate3;
	}

	@Override
	public String toString() {
		return "CommentDTO [cnum=" + cnum + ", fnum=" + fnum + ", comment=" + comment + ", writer=" + writer
				+ ", regDate3=" + regDate3 + "]";
	}

}
