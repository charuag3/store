package com.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@XmlRootElement
public class User {
	@Column(name="fname")
String fName;
	@Column(name="lname")
String lName;
@Id
@Column(name="username")
String userName;
String password;
String email;
@Column(name="contactno")
String contactNo;
String type;
String image;
public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
}
public String getlName() {
	return lName;
}
public void setlName(String lName) {
	this.lName = lName;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContactNo() {
	return contactNo;
}
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
@Override
public String toString() {
	return "User [fName=" + fName + ", lName=" + lName + ", userName=" + userName + ", password=" + password
			+ ", email=" + email + ", contactNo=" + contactNo + ", type=" + type + ", image=" + image + "]";
}

}
