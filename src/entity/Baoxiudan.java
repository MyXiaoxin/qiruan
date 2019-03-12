package entity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddRepairDAO;

public class Baoxiudan {
	public Baoxiudan() {};
	
	private int id;
	private String bx_stu;
	private String place;
	private String thing;
	private String description;
	private int status;
	private String wx_result;
	private String wx_person;
	private int wx_person_id;
	private String phone;
	private String tx_pic_url;
	
	
	public String getTx_pic_url() {
		return tx_pic_url;
	}
	public void setTx_pic_url(String tx_pic_url) {
		this.tx_pic_url = tx_pic_url;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getWx_person_id() {
		return wx_person_id;
	}
	public void setWx_person_id(int wx_person_id) {
		this.wx_person_id = wx_person_id;
	}

	private String bx_time;
	private String wx_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBx_stu() {
		return bx_stu;
	}
	public void setBx_stu(String bx_stu) {
		this.bx_stu = bx_stu;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getThing() {
		return thing;
	}
	public void setThing(String thing) {
		this.thing = thing;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getWx_result() {
		return wx_result;
	}
	public void setWx_result(String wx_result) {
		this.wx_result = wx_result;
	}
	public String getWx_person() {
		return wx_person;
	}
	public void setWx_person(String wx_person) {
		this.wx_person = wx_person;
	}
	public String getBx_time() {
		return bx_time;
	}
	public void setBx_time(String bx_time) {
		this.bx_time = bx_time;
	}
	public String getWx_time() {
		return wx_time;
	}
	public void setWx_time(String wx_time) {
		this.wx_time = wx_time;
	}
	


}
