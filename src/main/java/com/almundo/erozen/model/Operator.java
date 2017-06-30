package com.almundo.erozen.model;

public class Operator extends Employee{

	public Operator(String name) {
		super(name);
	}

	@Override
	public Integer getPriority() {
		return Thread.MAX_PRIORITY;
	}

}
