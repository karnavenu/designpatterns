package com.practice.dp.employee;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Venu Karna
 *
 */
public class EmployeeRatingVisitor implements IEmployeeVisitor {

	PriorityQueue<IEmployee> pQueue = new PriorityQueue<IEmployee>(10,
			EmployeeComparator.ratingComparator);

	@Override
	public void visit(IEmployee employee) {
		
		List<IEmployee> subordinates = employee.getDirectSubordinates();
		if (subordinates != null) {
			for (IEmployee empNode : subordinates) {
				pQueue.add(empNode);
				if(empNode.isManager())
					empNode.accept(this);
			}
		}

	}

	@Override
	public void printEmployees(int percentageEmployees) {
		EmployeeUtils.getInstance().printAllEmployeesBasedOnRating(pQueue, percentageEmployees);
	}
}
