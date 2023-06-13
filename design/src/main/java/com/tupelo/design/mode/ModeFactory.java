package com.tupelo.design.mode;

import com.tupelo.design.service.*;

/**
 * @Author: caichuang
 * @Date: 2023/2/6 11:00
 */
public interface ModeFactory {


	Person createPerson();

	public static void main(String[] args) {

		ModeFactory modeFactory = new LisiFactory();
		Person person = modeFactory.createPerson();
		person.doRun();
	}


}
