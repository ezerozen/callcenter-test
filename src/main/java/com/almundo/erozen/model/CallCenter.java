package com.almundo.erozen.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.almundo.erozen.util.CallCenterUtils;

public class CallCenter implements Runnable {

	private BlockingQueue<Employee> employees;
	private Call call;

	public CallCenter(BlockingQueue<Employee> employees, Call call) {
		super();
		this.employees = employees;
		this.call = call;
	}

	@Override
	public void run() {
		try {
			/*
			 * Saco un empleado de la Queue, al ser una PriorityBlockingQueue
			 * cuando hace un "poll" va respetar la prioridad definida por el
			 * comparator implementado (EmployeePriorityComparator) y en caso de
			 * no haber mas empleados en la Queue va a esperar un tiempo definido
			 * en la llamada hasta que ingrese otro.
			 */
			Employee employee = employees.poll(this.call.getCallWaitingTime(), TimeUnit.SECONDS);
			if (employee == null) {

				/*
				 * En caso de dar Timeout el metodo "poll" devuelve null por eso
				 * es que lanzo un TimeoutException.
				 */
				throw new TimeoutException(String.format("Timeout[%s seg.] waiting employee, lost call id[%s]",this.call.getCallWaitingTime(),this.call.getId()));
			}

			Integer duration = CallCenterUtils.getRandomDuration();

			/*
			 * Espero la cantidad de tiempo definida para simular una llamada.
			 */
			System.out.println(String.format("Start call id[%s] with employee[%s] (%s) duration[%s seg.]",
					this.call.getId(), employee.getName(), employee.getPosition(), duration));
			Thread.sleep(duration * 1000);
			System.out.println(String.format("Finish call id[%s] with employee[%s] (%s) duration[%s seg.]",
					this.call.getId(), employee.getName(), employee.getPosition(), duration));

			/*
			 * Cuando termina la llamada vuelvo a agregar el empleado a la Queue
			 * para que pueda tomar otras llamadas.
			 */
			employees.add(employee);
		} catch (InterruptedException | TimeoutException e) {
			e.printStackTrace();
		}
	}

}
