/**
 * 
 */
package com.portal;

import java.util.Date;

/**
 * @author Kaibo
 * 
 */
public class Employee implements Comparable<Employee> {
	private Name name;
	private int number;
	private Date hireDate;

	public Employee(Name name, int number, Date hireDate) {
		this.name = name;
		this.number = number;
		this.hireDate = hireDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		if (null == o)
			return 1;
		return Integer.compare(this.number, o.number);
	}

	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return the hireDate
	 */
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * @param hireDate
	 *            the hireDate to set
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [name=" + name + ", number=" + number + ", hireDate="
				+ hireDate + "]";
	}
	
}