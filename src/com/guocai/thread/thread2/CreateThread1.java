package com.guocai.thread.thread2;

import java.util.Arrays;

/**
 * java类简单作用描述
 *
 * @ProjectName: J2EE
 * @Package: com.guocai.thread2
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 10:02
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class CreateThread1 {
	public static void main(String[] args) {
		Thread t = new Thread(()->{
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		},"myThread");
		t.start();
		System.out.println(t.getThreadGroup().getName());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getThreadGroup().getName());

		System.out.println(Thread.activeCount());

		Thread[] threads = new Thread[Thread.activeCount()];
		Thread.enumerate(threads);

		Arrays.asList(threads).forEach(System.out::println);
	}
}
