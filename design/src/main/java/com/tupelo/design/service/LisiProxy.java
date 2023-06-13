package com.tupelo.design.service;

/**
 * @Author: caichuang
 * @Date: 2023/5/24 16:31
 */
public class LisiProxy extends Person {

	private Person person;

	public LisiProxy(){
		this.person = new Lisi();
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
