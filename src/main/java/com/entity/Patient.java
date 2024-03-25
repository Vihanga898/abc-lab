package com.entity;

public class Patient {
    private int patientId;
    private String fullName;
    private String age;
    private String address;
    private String email;
    private String password;

    public Patient() {
    }

    public Patient(int patientId, String fullName, String age, String address, String email, String password) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.email = email;
        this.password = password;
    }

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}