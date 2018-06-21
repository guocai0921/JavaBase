package com.guocai.thread.thread1;

/**
 * java类简单作用描述
 *
 * @ProjectName: J2EE
 * @Package: com.guocai.thread1
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 9:27
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class SimpleCalculatorStrategy implements CalculatorStrategy {

	private static final double SALARY_RATE = 0.01d;
	private static final double BONUS_RATE = 0.015d;

	@Override
	public double calculate(double salary, double bonus) {
		return salary * SALARY_RATE + bonus * BONUS_RATE;
	}
}
