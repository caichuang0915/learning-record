package com.tupelo.design.service;

/**
 * @Author: caichuang
 * @Date: 2023/5/24 16:31
 */
public class Decorator extends Person {

	private Person person;

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public void doRun() {
		person.doRun();
	}

	@Override
	public void doSay() {
		person.doSay();
	}
}
