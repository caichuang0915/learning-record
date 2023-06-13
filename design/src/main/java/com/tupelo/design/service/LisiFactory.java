package com.tupelo.design.service;

import com.tupelo.design.mode.ModeFactory;

/**
 * @Author: caichuang
 * @Date: 2023/5/24 16:31
 */
public class LisiFactory implements ModeFactory {

	@Override
	public Person createPerson() {
		return new Lisi();
	}
}
