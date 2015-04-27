package com.practice.dp.employee;

import java.util.PriorityQueue;

/**
 * @author Venu Karna
 * 
 */
public class EmployeeUtils {

	private static EmployeeUtils instance = null;

	private EmployeeUtils() {
		if (instance != null)
			throw new IllegalStateException("Only one instance may be created");
	}

	public static synchronized EmployeeUtils getInstance() {
		if (instance == null) {
			instance = new EmployeeUtils();
		}
		return instance;
	}

	public void printAllEmployeesBasedOnRating(PriorityQueue<IEmployee> pQueue,
			float percentage) {
		percentage = (percentage * pQueue.size()) / 100;
		int empMaxCount = Math.round(percentage);

		if (pQueue != null) {
			while (true) {
				IEmployee empNode = pQueue.poll();
				if (empMaxCount > 0)
					System.out.println("QueueImpl,printing based on rating: "
							+ empNode.getName());
				else
					break;

				empMaxCount--;
			}
		}
	}
	
	
	
	
	


//	/**
//	 * Find percentage of top employees(as per rating) under a given employee
//	 * Implementation using array list for all subordinates hierarchy
//	 * 
//	 * @param emp
//	 * @param percentage
//	 * @param ratingcomparator 
//	 */
//	public void printAllSubordinatesUsingListImpl(IEmployee emp,
//			float percentage, Comparator<IEmployee> ratingcomparator) {
//		// Find all employee under a given employee with rating > 5
//		List<IEmployee> subordinates = emp
//				.getAllSubordinatesUsingList(new ArrayList<IEmployee>());
//		Collections.sort(subordinates,ratingcomparator);
//		percentage = (percentage * subordinates.size()) / 100;
//		int empMaxCount = Math.round(percentage);
//		if (subordinates != null) {
//			for (IEmployee empNode : subordinates) {
//				if (empMaxCount > 0)
//					System.out.println("ListImpl, printing based on rating: "
//							+ empNode.getName());
//				else
//					break;
//				empMaxCount--;
//			}
//		}
//	}
//
//	/**
//	 * Find percentage of top employees(as per rating) under a given employee
//	 * Implementation using priority queue for all subordinates hierarchy
//	 * 
//	 * @param emp
//	 * @param percentage
//	 * @param ratingcomparator 
//	 */
//	public void printAllSubordinatesUsingQueueImpl(IEmployee emp,
//			float percentage, Comparator<IEmployee> ratingcomparator) {
//		PriorityQueue<IEmployee> pQueue = new PriorityQueue<IEmployee>(10,ratingcomparator);
//		PriorityQueue<IEmployee> subordinates = emp
//				.getAllSubordinatesUsingQueue(pQueue);
//		percentage = (percentage * subordinates.size()) / 100;
//		int empMaxCount = Math.round(percentage);
//
//		if (subordinates != null) {
//			while (true) {
//				IEmployee empNode = subordinates.poll();
//				if (empMaxCount > 0)
//					System.out.println("QueueImpl,printing based on rating: "
//							+ empNode.getName());
//				else
//					break;
//
//				empMaxCount--;
//			}
//		}
//	}
}
