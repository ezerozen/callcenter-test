package com.almundo.erozen.comparator;

import java.util.Comparator;

import com.almundo.erozen.model.Employee;

public class EmployeePriorityComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o2.getPriority().compareTo(o1.getPriority());
	}

}
