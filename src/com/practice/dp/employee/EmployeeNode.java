package com.practice.dp.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Venu Karna
 *
 */
public class EmployeeNode implements IEmployee {
	String name = "";
	int rating = 0;
	List<IEmployee> subordinates = new ArrayList<IEmployee>();

	public EmployeeNode(String name, int rating) {
		this.name = name;
		this.rating = rating;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public int getRating() {
		return this.rating;
	}

	@Override
	public void setRating(int rating) {
		this.rating = rating;

	}

	@Override
	public boolean isManager() {
		if (subordinates != null && subordinates.size() > 0)
			return true;

		return false;
	}

	@Override
	public void addDirectSubordinates(IEmployee emp) {
		subordinates.add(emp);

	}

	@Override
	public List<IEmployee> getDirectSubordinates() {
		return this.subordinates;
	}

	@Override
	public void accept(IEmployeeVisitor visitor) {
		visitor.visit(this);
		
	}
}
