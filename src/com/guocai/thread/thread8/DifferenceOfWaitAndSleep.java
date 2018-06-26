package com.guocai.thread.thread8;

/**
 * java类简单作用描述
 *
 * @ClassName: DifferenceOfWaitAndSleep
 * @Package: com.guocai.thread.thread8
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/25 9:54
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class DifferenceOfWaitAndSleep {

	public static Object LOCK = new Object();

	public static void main(String[] args) {
		m2();
	}

	//release

	public static void m1(){
		try {
			Thread.sleep(2_000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void m2(){
		try {
			LOCK.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
