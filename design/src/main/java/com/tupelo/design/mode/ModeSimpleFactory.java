package com.tupelo.design.mode;

import com.tupelo.design.service.Lisi;
import com.tupelo.design.service.Person;
import com.tupelo.design.service.Stranger;
import com.tupelo.design.service.Zhangsan;

/**
 * @Author: caichuang
 * @Date: 2023/2/6 11:00
 */
public class ModeSimpleFactory {

	public static Person getPerson(String name){

		if("张三".equals(name)){
			return new Zhangsan();
		}

		if("李四".equals(name)){
			return new Lisi();
		}

		return new Stranger();
	}

	public static void main(String[] args) {
		Person person = ModeSimpleFactory.getPerson("张三");
		person.doRun();
	}



}
