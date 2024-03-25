package com.entity;

public class Appointment {
	private int id;
    private int patientId;
    private String fullname;
    private String gender;
    private String age;
    private String appointDate;
    private String email;
    private String phNo;
    private int testId;
    private String testName;
    private String address;
    private int technicianId;
    private String status;
    

    public Appointment() {
		super();
	}

	// Constructor with all fields
    public Appointment(int id, int patientId, String fullname, String gender, String age, String appointDate, String email, String phNo, int testId, String testName, String address, int technicianId, String status) {
        this.id = id;
    	this.patientId = patientId;
        this.fullname = fullname;
        this.gender = gender;
        this.age = age;
        this.appointDate = appointDate;
        this.email = email;
        this.phNo = phNo;
        this.testId = testId;
        this.testName = testName;
        this.address = address;
        this.technicianId = technicianId;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAppointDate() {
		return appointDate;
	}

	public void setAppointDate(String appointDate) {
		this.appointDate = appointDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTechnicianId() {
		return technicianId;
	}

	public void setTechnicianId(int technicianId) {
		this.technicianId = technicianId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
