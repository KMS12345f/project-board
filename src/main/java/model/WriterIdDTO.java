package model;

public class WriterIdDTO {
	int wrid;
	String writer;
	
	public int getWrid() {
		return wrid;
	}
	public void setWrid(int wrid) {
		this.wrid = wrid;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public WriterIdDTO() {
	}
	public WriterIdDTO(int wrid, String writer) {
		this.wrid = wrid;
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "WriterIdDTO [wrid=" + wrid + ", writer=" + writer + "]";
	}
	public WriterIdDTO(String writer) {
		this.writer = writer;
	}
	public WriterIdDTO(int wrid) {
		super();
		this.wrid = wrid;
	}
	
	
}
