package com.almundo.erozen.comparator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.almundo.erozen.model.Chief;
import com.almundo.erozen.model.Operator;
import com.almundo.erozen.model.Supervisor;

public class EmployeePriorityComparatorTest {

	@Test
	public void compare_operatorvssupervisor_operator() {
		EmployeePriorityComparator comparator = new EmployeePriorityComparator();
		Operator operator = new Operator("Name");
		Supervisor supervisor = new Supervisor("Name");
		int result = comparator.compare(operator, supervisor);
		assertEquals(result, -1);
	}
	
	@Test
	public void compare_supervisorvschief_chief() {
		EmployeePriorityComparator comparator = new EmployeePriorityComparator();
		Chief chief = new Chief("Name");
		Supervisor supervisor = new Supervisor("Name");
		int result = comparator.compare(supervisor, chief);
		assertEquals(result, -1);
	}
	
	@Test
	public void compare_operatorvschief_chief() {
		EmployeePriorityComparator comparator = new EmployeePriorityComparator();
		Operator operator = new Operator("Name");
		Chief chief = new Chief("Name");
		int result = comparator.compare(operator, chief);
		assertEquals(result, -1);
	}
	
	@Test
	public void compare_operatorvsoperator_equals() {
		EmployeePriorityComparator comparator = new EmployeePriorityComparator();
		Operator operator = new Operator("Name");
		Operator operator1 = new Operator("Name");
		int result = comparator.compare(operator, operator1);
		assertEquals(result, 0);
	}

}
