package com.entity;

public class TestType {
    private int id;
    private String testName;
    private double testPrice;
	public TestType() {
		super();
	}
	public TestType(int id, String testName, double testPrice) {
		super();
		this.id = id;
		this.testName = testName;
		this.testPrice = testPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public double getTestPrice() {
		return testPrice;
	}
	public void setTestPrice(double testPrice) {
		this.testPrice = testPrice;
	}

  
    }

    // Getters and setters for id, testName, and testPrice...

