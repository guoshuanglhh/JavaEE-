package com.zhiyou.pojo;

import java.util.Date;

public class User{
	private int u_id;
	private String u_name;
	private String u_password;
	private String u_realname;
	private String u_sex;
	private int role_id;
	private Date u_create_time;
	private short u_status;
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_realname() {
		return u_realname;
	}
	public void setU_realname(String u_realname) {
		this.u_realname = u_realname;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public Date getU_create_time() {
		return u_create_time;
	}
	public void setU_create_time(Date u_create_time) {
		this.u_create_time = u_create_time;
	}
	public short getU_status() {
		return u_status;
	}
	public void setU_status(short u_status) {
		this.u_status = u_status;
	}
}
