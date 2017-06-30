package com.almundo.erozen;

import com.almundo.erozen.model.Call;
import com.almundo.erozen.repository.EmployeeRepository;

public class CallCenterApp {

	private static final Integer CALL_WAITING_TIME = 11;

	public static void main(String[] args) throws InterruptedException {
		EmployeeRepository repository = new EmployeeRepository();
		CallCenterDispatcher dispatcher = new CallCenterDispatcher(repository.getAll());
		for (int i = 0; i < 10; i++) {
			dispatcher.dispatchCall(new Call(Long.valueOf(i),CALL_WAITING_TIME));
		}
	}

}
