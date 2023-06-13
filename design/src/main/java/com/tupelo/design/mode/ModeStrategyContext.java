package com.tupelo.design.mode;

import com.tupelo.design.service.Person;

/**
 * @Author: caichuang
 * @Date: 2023/2/6 11:00
 */
public class ModeStrategyContext {

	private Person person;

	public ModeStrategyContext(String name){
		this.person = ModeSimpleFactory.getPerson(name);
	}

	public void doSay(){
		person.doSay();
	}


	public static void main(String[] args) {

		ModeStrategyContext modeStrategyContext = new ModeStrategyContext("张三");
		modeStrategyContext.doSay();
	}



}
