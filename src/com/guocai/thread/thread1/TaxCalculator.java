package com.guocai.thread.thread1;

/**
 * java类简单作用描述
 *
 * @ProjectName: J2EE
 * @Package: com.guocai.thread1
 * @Description: < Thread的创建是基于策略模式实现的 >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 9:07
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class TaxCalculator {
	private final double salary;
	private final double bonus;

	public TaxCalculator(double salary, double bonus) {
		this.salary = salary;
		this.bonus = bonus;
	}

	private CalculatorStrategy calculatorStrategy;

	protected double calcTax(){
		return calculatorStrategy.calculate(salary,bonus);
	}

	public double calculate(){
		return this.calcTax();
	}

	public double getSalary() {
		return salary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setCalculatorStrategy(CalculatorStrategy calculatorStrategy) {
		this.calculatorStrategy = calculatorStrategy;
	}
}
