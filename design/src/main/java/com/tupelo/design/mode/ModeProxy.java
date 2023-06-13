package com.tupelo.design.mode;

import com.tupelo.design.service.Decorator;
import com.tupelo.design.service.LisiDecorator;
import com.tupelo.design.service.LisiProxy;
import com.tupelo.design.service.Person;

/**
 * @Author: caichuang
 * @Date: 2023/2/6 11:00
 */
public class ModeProxy {



	public static void main(String[] args) {

		LisiProxy lisiProxy = new LisiProxy();
		lisiProxy.doRun();
	}



}
