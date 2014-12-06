package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "studentbean")
public class Studentbean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	//@Id
	//@Column(name="studentid", nullable=false,unique=true)
	//private int IDs;
	private String studentId;
	//@Column(nullable=false)
	private String name;
	//@Column(nullable=false)
	private String address;
	//@Column(nullable=false)
	private String city;
	//@Column(nullable=false)
	private String state;
	//@Column(nullable=false)
	private String zip;
	//@Column(nullable=false)
	private String tel;
	//@Column(nullable=false)
	private String email;
	//@Column(nullable=false)
	private String url;
	//@Column(nullable=false)
	private String dates;
	//@Column(nullable=false)
	private String like;
	//@Column(nullable=false)
	private String how;
	//@Column(nullable=false)
	private String graduationMonth;
	//@Column(nullable=false)
	private String year;
	//@Column(nullable=false)
	private String recommendation;
	//@Column(nullable=false)
	private String comment;
	//@Column(nullable=false)
	private String data;
	
	

	

	@Override
	public String toString() {
		return "Studentbean [studentId=" + studentId
				+ ", name=" + name + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", tel=" + tel
				+ ", email=" + email + ", url=" + url + ", dates=" + dates
				+ ", like=" + like + ", how=" + how + ", graduationMonth="
				+ graduationMonth + ", year=" + year + ", recommendation="
				+ recommendation + ", comment=" + comment + ", data=" + data
				+ "]";
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public String getHow() {
		return how;
	}
	public void setHow(String how) {
		this.how = how;
	}
	public String getGraduationMonth() {
		return graduationMonth;
	}
	public void setGraduationMonth(String graduationMonth) {
		this.graduationMonth = graduationMonth;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Studentbean(String studentId, String name, String address,
			String city, String state, String zip, String tel, String email,
			String url, String date, String like, String how,
			String graduationMonth, String year, String recommendation,
			String comment, String data) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.tel = tel;
		this.email = email;
		this.url = url;
		this.dates = date;
		this.like = like;
		this.how = how;
		this.graduationMonth = graduationMonth;
		this.year = year;
		this.recommendation = recommendation;
		this.comment = comment;
		this.data = data;
	}
	public Studentbean(){
		this.studentId = "";
		this.name = "";
		this.address = "";
		this.city = "";
		this.state = "";
		this.zip = "";
		this.tel = "";
		this.email ="";
		this.url = "";
		this.dates = "";
		this.like = "";
		this.how = "";
		this.graduationMonth ="";
		this.year = "";
		this.recommendation = "";
		this.comment = "";
		this.data = "";
		
		
	}/*
	public int getIDs() {
		return IDs;
	}
	public void setIDs(int iDs) {
		IDs = iDs;
	}*/
	
	
}

