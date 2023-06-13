package com.tupelo.design.mode;

import com.tupelo.design.service.*;

/**
 * @Author: caichuang
 * @Date: 2023/2/6 11:00
 */
public class ModeDecorator {



	public static void main(String[] args) {
		Person lisi = ModeSimpleFactory.getPerson("李四");
		Decorator decorator = new LisiDecorator();
		decorator.setPerson(lisi);
		decorator.doRun();
	}



}
