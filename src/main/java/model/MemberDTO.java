package model;

import java.util.Date;

public class MemberDTO {
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String birth;
	private String email;
	private String gender;
	private Date regDate1;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getRegDate1() {
		return regDate1;
	}
	public void setRegDate1(Date regDate1) {
		this.regDate1 = regDate1;
	}
	
	public MemberDTO() {

	}
	
	public MemberDTO(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone + ", birth=" + birth
				+ ", email=" + email + ", gender=" + gender + ", regDate1=" + regDate1 + "]";
	}
	public MemberDTO(String id, String pwd, String name, String phone, String birth, String email, String gender,
			Date regDate1) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.birth = birth;
		this.email = email;
		this.gender = gender;
		this.regDate1 = regDate1;
	}
	public MemberDTO(String id, String pwd, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}








	
	
	
}
