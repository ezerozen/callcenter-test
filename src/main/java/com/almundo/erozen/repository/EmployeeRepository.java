package com.almundo.erozen.repository;

import java.util.Arrays;
import java.util.List;

import com.almundo.erozen.model.Chief;
import com.almundo.erozen.model.Employee;
import com.almundo.erozen.model.Operator;
import com.almundo.erozen.model.Supervisor;

public class EmployeeRepository {

	private List<Employee> employees;

	public EmployeeRepository() {
		/*
		 * Creo 10 empleados ya que en el enunciado pide procesar 10 llamadas
		 * concurrentes.
		 */
		this.employees = Arrays.asList(new Chief("Martin"), new Supervisor("Juan"), new Supervisor("Pablo"),
				new Operator("Ezequiel"), new Operator("Leandro"), new Operator("Pedro"), new Operator("Camila"),
				new Operator("Gabriela"), new Operator("Diego"), new Operator("Luiz"));
	}

	public List<Employee> getAll() {
		return this.employees;
	}

}
