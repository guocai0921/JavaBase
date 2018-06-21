package com.guocai.thread.thread1;

/**
 * java类简单作用描述
 *
 * @ProjectName: J2EE
 * @Package: com.guocai.thread1
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 9:13
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class TaxCalculatorMain
{
	public static void main(String[] args) {
		/*TaxCalculator tc = new TaxCalculator(10000d,2000d){
			@Override
			protected double calcTax() {
				return getSalary()*0.01+getBonus()*0.015;
			}
		};

		double v = tc.calculate();
		System.out.println(v);*/


		TaxCalculator tc = new TaxCalculator(10000d,2000d);
		CalculatorStrategy calculatorStrategy = new SimpleCalculatorStrategy();
		tc.setCalculatorStrategy(calculatorStrategy);
		tc.calcTax();
	}
}
