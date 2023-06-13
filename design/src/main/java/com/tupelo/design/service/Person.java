package com.tupelo.design.service;

/**
 * @Author: caichuang
 * @Date: 2023/5/24 16:31
 */
public abstract class Person {

	private String name;
	private Person child;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getChild() {
		return child;
	}

	public void setChild(Person child) {
		this.child = child;
	}

	public abstract void doRun();

	public abstract void doSay();
}
