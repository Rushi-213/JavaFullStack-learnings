package com.MVC;

public class AddInfo {
	private int id;
	private String myname;
	private String myemail;
	private String mycity;
	private int myage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMyname() {
		return myname;
	}
	public void setMyname(String myname) {
		this.myname = myname;
	}
	public String getMyemail() {
		return myemail;
	}
	public void setMyemail(String myemail) {
		this.myemail = myemail;
	}
	public String getMycity() {
		return mycity;
	}
	public void setMycity(String mycity) {
		this.mycity = mycity;
	}
	public int getMyage() {
		return myage;
	}
	public void setMyage(int myage) {
		this.myage = myage;
	}
	@Override
	public String toString() {
		return "Addinfo [id=" + id + ", myname=" + myname + ", myemail=" + myemail + ", mycity=" + mycity + ", myage="
				+ myage + "]";
	}
	
	
}
