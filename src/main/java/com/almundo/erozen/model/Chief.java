package com.almundo.erozen.model;

public class Chief extends Employee{

	public Chief(String name) {
		super(name);
	}

	@Override
	public Integer getPriority() {
		return Thread.MIN_PRIORITY;
	}

}
