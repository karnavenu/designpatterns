package com.practice.dp.employee;


/**
 * @author Venu Karna
 *
 */
public class EmployeeTest {
	/*
	 * 			
	 *            1 
	 *  		/ \
	 * 	       2   3
	 *       / \    \   
	 *       4 5     6 
	 *      /|\
	 *     7 8 9
	 * 
	 * Find percentage of top employees(as per rating) under a given employee
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int percentageEmployees = 50;
		IEmployee emp1 = new EmployeeNode("emp1", IEmployee.RATING.ONE.ordinal());
		IEmployee emp2 = new EmployeeNode("emp2", IEmployee.RATING.TWO.ordinal());
		IEmployee emp3 = new EmployeeNode("emp3", IEmployee.RATING.THREE.ordinal());
		IEmployee emp4 = new EmployeeNode("emp4", IEmployee.RATING.FOUR.ordinal());
		IEmployee emp5 = new EmployeeNode("emp5", IEmployee.RATING.FIVE.ordinal());
		IEmployee emp6 = new EmployeeNode("emp6", IEmployee.RATING.SIX.ordinal());
		IEmployee emp7 = new EmployeeNode("emp7", IEmployee.RATING.SEVEN.ordinal());
		IEmployee emp8 = new EmployeeNode("emp8", IEmployee.RATING.EIGHT.ordinal());
		IEmployee emp9 = new EmployeeNode("emp9", IEmployee.RATING.NINE.ordinal());

		emp1.addDirectSubordinates(emp2);
		emp1.addDirectSubordinates(emp3);
		emp2.addDirectSubordinates(emp4);
		emp2.addDirectSubordinates(emp5);
		emp3.addDirectSubordinates(emp6);
		emp4.addDirectSubordinates(emp7);
		emp4.addDirectSubordinates(emp8);
		emp4.addDirectSubordinates(emp9);
		
		IEmployeeVisitor visitor = new EmployeeRatingVisitor();
		visitor.visit(emp1);
		visitor.printEmployees(percentageEmployees);

	}
}
