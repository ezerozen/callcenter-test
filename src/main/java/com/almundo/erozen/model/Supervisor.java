package com.almundo.erozen.model;

public class Supervisor extends Employee{

	public Supervisor(String name) {
		super(name);
	}

	@Override
	public Integer getPriority() {
		return Thread.NORM_PRIORITY;
	}

}
