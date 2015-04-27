package com.practice.dp.employee;

import java.util.Comparator;

/**
 * @author Venu Karna
 * 
 */
public abstract class EmployeeComparator {
	public static final Comparator<IEmployee> ratingComparator = new Comparator<IEmployee>() {
		@Override
		public int compare(IEmployee o1, IEmployee o2) {
			return o2.getRating() - o1.getRating(); // Assuming employee rating
													// will be positive integer
		}

	};
}
