package com.almundo.erozen.model;

public class Call{

	private Long id;
	private Integer callWaitingTime;

	public Call(Long id, Integer callWaitingTime) {
		super();
		this.id = id;
		this.callWaitingTime = callWaitingTime;
	}
	
	public Long getId() {
		return id;
	}

	public Integer getCallWaitingTime() {
		return callWaitingTime;
	}
	
}
