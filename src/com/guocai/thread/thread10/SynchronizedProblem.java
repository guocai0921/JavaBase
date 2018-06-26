package com.guocai.thread.thread10;

/**
 * java类简单作用描述
 *
 * @ClassName: SynchronizedPromble
 * @Package: com.guocai.thread.thread10
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/26 9:18
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class SynchronizedProblem {

	public static void main(String[] args) {
		new Thread(()->run(),"T1").start();
		new Thread(()->run(),"M1").start();
	}

	private static void run(){
		for (int i = 0; i < 500; i++) {
			System.out.println(Thread.currentThread().getName()+" is working ..." + i);
		}
	}

}
