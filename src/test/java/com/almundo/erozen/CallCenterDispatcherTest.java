package com.almundo.erozen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.almundo.erozen.model.Call;
import com.almundo.erozen.repository.EmployeeRepository;

public class CallCenterDispatcherTest {

	/*
	 * Test con 10 llamadas concurrentes: Procesa las 10 llamadas al mismo
	 * tiempo
	 */
	@Test
	public void dispatchCall_10calls_process10calls() throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		EmployeeRepository repository = new EmployeeRepository();
		CallCenterDispatcher dispatcher = new CallCenterDispatcher(repository.getAll(), executorService);
		for (int i = 0; i < 10; i++) {
			dispatcher.dispatchCall(new Call(Long.valueOf(i), 11));
		}
		executorService.shutdown();
		executorService.awaitTermination(11, TimeUnit.SECONDS);
	}

	/*
	 * Resolvi los puntos extras usando una {@link
	 * java.util.concurrent.PriorityBlockingQueue} para "encolar" los empleados
	 * y de esta forma resolver el problema de la prioridad y la espera hasta
	 * que un empleado este disponible.
	 * 
	 * Test con 15 llamadas concurrentes: Como solo puede procesar 10 llamadas
	 * al mismo tiempo, primero procesa las primeras 10 y a medida que se van
	 * liberando los empleados se le asigna una llamada nueva hasta procesar las
	 * 15.
	 */
	@Test
	public void dispatchCall_15calls_process10callsAndWait5more() throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		EmployeeRepository repository = new EmployeeRepository();
		CallCenterDispatcher dispatcher = new CallCenterDispatcher(repository.getAll(), executorService);
		for (int i = 0; i < 15; i++) {
			dispatcher.dispatchCall(new Call(Long.valueOf(i), 11));
		}
		executorService.shutdown();
		executorService.awaitTermination(21, TimeUnit.SECONDS);
	}

	/*
	 * Test con 15 llamadas concurrentes y un tiempo de llamada en espera de
	 * 4seg: Procesa las primeras 10 llamadas y las siguientes 5 llamadas se
	 * pierden por timeout.
	 */
	@Test
	public void dispatchCall_15calls_process10callsAnd5timeout() throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		EmployeeRepository repository = new EmployeeRepository();
		CallCenterDispatcher dispatcher = new CallCenterDispatcher(repository.getAll(), executorService);
		for (int i = 0; i < 15; i++) {
			dispatcher.dispatchCall(new Call(Long.valueOf(i), 4));
		}
		executorService.shutdown();
		executorService.awaitTermination(11, TimeUnit.SECONDS);
	}

}
