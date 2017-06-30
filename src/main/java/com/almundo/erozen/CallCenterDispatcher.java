package com.almundo.erozen;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

import com.almundo.erozen.comparator.EmployeePriorityComparator;
import com.almundo.erozen.model.Call;
import com.almundo.erozen.model.CallCenter;
import com.almundo.erozen.model.Employee;

public class CallCenterDispatcher {

	private static final int MAX_THREADS = 50;

	private BlockingQueue<Employee> employees;
	private ExecutorService executorService;

	public CallCenterDispatcher(List<Employee> sourceEmployees, ExecutorService executorService) {
		this.executorService = executorService;
		/*
		 * Instancio una PriorityBlockingQueue con capacidad inicial de la
		 * cantidad de empleados y un EmployeePriorityComparator para respetar la prioridad
		 * segun el tipo de empleado.
		 */
		this.employees = new PriorityBlockingQueue<Employee>(sourceEmployees.size(), new EmployeePriorityComparator());
		this.employees.addAll(sourceEmployees);
	}

	public CallCenterDispatcher(List<Employee> sourceEmployees) {
		/*
		 * Por defecto se instancia un ThreadPoolExecutor con una cantidad fija de
		 * threads.
		 */
		this(sourceEmployees, Executors.newFixedThreadPool(MAX_THREADS));
	}

	public void dispatchCall(Call call) {
		/*
		 * Instancio una tarea con la Queue de empleados y una llamada
		 * para enviar al ThreadPoolExecutor y procesar.
		 */
		this.executorService.submit(new CallCenter(this.employees, call));
	}

}
