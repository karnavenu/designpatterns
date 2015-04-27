package com.practice.dp.employee;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Venu Karna
 *
 */
public interface IEmployee  {

	public enum RATING {
		ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN
	};

	public abstract String getName();

	public abstract void setName(String name);

	public abstract int getRating();

	public abstract void setRating(int rating);

	public abstract boolean isManager();

	public abstract void addDirectSubordinates(IEmployee emp);

	public abstract List<IEmployee> getDirectSubordinates();
	
	public void accept(IEmployeeVisitor visitor);
}
