package com.ust.payloads;

public class UserModel {

	public long id;
     public String employee_name;
     public long employee_salary;
     public int employee_age;
     public String profile_image;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public long getEmployee_salary() {
		return employee_salary;
	}
	public void setEmployee_salary(long employee_salary) {
		this.employee_salary = employee_salary;
	}
	public int getEmployee_age() {
		return employee_age;
	}
	public void setEmployee_age(int employee_age) {
		this.employee_age = employee_age;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", employee_name=" + employee_name + ", employee_salary=" + employee_salary
				+ ", employee_age=" + employee_age + ", profile_image=" + profile_image + ", getId()=" + getId()
				+ ", getEmployee_name()=" + getEmployee_name() + ", getEmployee_salary()=" + getEmployee_salary()
				+ ", getEmployee_age()=" + getEmployee_age() + ", getProfile_image()=" + getProfile_image()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public UserModel(long id, String employee_name, long employee_salary, int employee_age, String profile_image) {
		super();
		this.id = id;
		this.employee_name = employee_name;
		this.employee_salary = employee_salary;
		this.employee_age = employee_age;
		this.profile_image = profile_image;
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
