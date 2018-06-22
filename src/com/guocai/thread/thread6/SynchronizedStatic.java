package com.guocai.thread.thread6;

/**
 * java类简单作用描述
 *
 * @ClassName: SynchronizedStatic
 * @Package: com.guocai.thread.thread6
 * @Description: < 类锁 >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/22 14:10
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class SynchronizedStatic {


	static{
		synchronized (SynchronizedStatic.class) {
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(10_000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized static void m1(){
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(10_000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized static void m2(){
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(10_000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public  static void m3(){
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(10_000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SynchronizedStatic synchronizedStatic = new SynchronizedStatic();

		new Thread(()->synchronizedStatic.m1(),"T1").start();
		new Thread(()->synchronizedStatic.m2(),"T2").start();
		new Thread(()->synchronizedStatic.m3(),"T3").start();
	}
}
