package com.tupelo.design.mode;

import com.tupelo.design.service.*;

/**
 * @Author: caichuang
 * @Date: 2023/2/6 11:00
 */
public class ModeClone {



	public static void main(String[] args) throws CloneNotSupportedException {

		StrangerClone strangerClone = new StrangerClone();
		strangerClone.setName("陌生人");
		Person person = new Zhangsan();
		person.setName("张三");
		strangerClone.setChild(person);
		Person clone = (Person) strangerClone.clone();
		clone.doRun();
		String name = clone.getName();
		System.out.println(name);
		Person zs = clone.getChild();
		System.out.println(zs.getName());
		zs.setName("李四");
		clone.setName("李四");
		System.out.println(strangerClone.getChild().getName());
		System.out.println(strangerClone.getName());

	}



}
