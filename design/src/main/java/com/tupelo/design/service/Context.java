package com.tupelo.design.service;

/**
 * @Author: caichuang
 * @Date: 2023/5/31 17:19
 */
public class Context {

	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}


	public void contextDoSomething() {
		strategy.doSomething();
	}


	public static void main(String[] args) {
		Strategy strategyA = new StrategyA();
		Context context = new Context(strategyA);
		context.contextDoSomething();
	}

}
