package com.practice.dp.employee;

/**
 * @author Venu Karna
 *
 */
public interface IEmployeeVisitor {
	public void visit(IEmployee employee);
	public void printEmployees(int percentageEmployees);
}
