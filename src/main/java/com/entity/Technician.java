package com.entity;

public class Technician {
    
    private int technicianId;
    private String name;
    private String mobno;
    private String email;
    private String address;
    private String testName;
    private String password;

    public Technician() {
        super();
    }

    public Technician(int technicianId, String name, String mobno, String email, String address, String testName,
            String password) {
        super();
        this.technicianId = technicianId;
        this.name = name;
        this.mobno = mobno;
        this.email = email;
        this.address = address;
        this.testName = testName;
        this.password = password;
    }

	public int getTechnicianId() {
		return technicianId;
	}

	public void setTechnicianId(int technicianId) {
		this.technicianId = technicianId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    

}
