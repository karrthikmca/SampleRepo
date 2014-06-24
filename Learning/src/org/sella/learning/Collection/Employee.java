package org.sella.learning.Collection;

import java.util.Date;

public class Employee implements Comparable<Employee> {
	private Long id;
	private String name;
	private Date dob;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(final Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("<Employee><id>");
		builder.append(id);
		builder.append("</id><name>");
		builder.append(name);
		builder.append("</name></Employee>");
		return builder.toString();
	}

	@Override
	public int compareTo(final Employee o) {
		System.out.println("this.id " + this.id + o.getId());
		System.out.println("this.name " + this.name + o.getName());
		if ((this.id.equals(o.getId()) && this.name.equals(o.getName()))) {
			System.out.println("Retrun 0");
			return 0;
		}
		return 1;
	}

	@Override
	public int hashCode() {
		int hashcode = 0;
		hashcode += id.intValue() * 10;
		hashcode += name.hashCode();
		hashcode += dob.hashCode();
		//System.out.println("Come Hash COde" + hashcode);
		return hashcode;
	}

	@Override
	public boolean equals(final Object obj) {
		//System.out.println("Come Equals");
		if (obj instanceof Employee) {
			final Employee obj1 = (Employee) obj;
			final boolean valid = (this.id.equals(obj1.getId()) && this.name.equals(obj1.getName()));
			//System.out.println("return "+valid);
			return valid;
		}
		return false;
	}
}