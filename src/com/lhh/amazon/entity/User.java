package com.lhh.amazon.entity;

import java.util.Date;

/**
 * 用户类
 * 
 * @author 46512
 *
 */
public class User {
	private Long userID = -1L;// 用户ID
	private String username;// 用户名字
	private String password;// 用户密码
	private byte sex;// 性别
	private Date birthday;// 生日
	private String identityCode;// 身份证
	private String email;// 邮箱
	private String mobile;// 手机
	private String address;// 住址
	private int status;// 状态

	public User(Long userID, String username, String password, byte sex, Date birthday, String identityCode,
			String email, String mobile, String address, int status) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.identityCode = identityCode;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.status = status;
	}

	public User() {
		super();
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getSex() {
		return sex;
	}

	public void setSex(byte sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdentityCode() {
		return identityCode;
	}

	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + ", sex=" + sex
				+ ", birthday=" + birthday + ", identityCode=" + identityCode + ", email=" + email + ", mobile="
				+ mobile + ", address=" + address + ", status=" + status + "]";
	}
	
}
