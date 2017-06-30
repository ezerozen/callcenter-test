package com.almundo.erozen.model;

public abstract class Employee{

	private String name;
	
	public Employee(String name){
		super();
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public abstract Integer getPriority();
	
	public String getPosition(){
		return this.getClass().getSimpleName();
	}
}
