package com.guocai.thread.thread12;

import java.util.Arrays;

/**
 * java类简单作用描述
 *
 * @ClassName: ThreadGroupCreate
 * @Package: com.guocai.thread.thread12
 * @Description: < 创建ThreadGroup >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/26 16:56
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class ThreadGroupCreate {

	public static void main(String[] args) {
		//System.out.println(Thread.currentThread().getName());
		//System.out.println(Thread.currentThread().getThreadGroup().getName());

		ThreadGroup tg1 = new ThreadGroup("TG1");
		Thread t1 = new Thread(){
			@Override
			public void run() {
				try {
					System.out.println(getThreadGroup().getName());
					System.out.println(getThreadGroup().getParent());
					System.out.println(getThreadGroup().getParent().activeCount());
					Thread.sleep(1_000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t1.start();

		ThreadGroup tg2 = new ThreadGroup("TG2");
		//System.out.println(threadGroup1.getName());
		//System.out.println(threadGroup1.getParent());

		Thread t2 = new Thread(tg2,"T2"){
			@Override
			public void run() {
				System.out.println("---------------------------");
				System.out.println(tg1.getName());
				Thread[] threads = new Thread[tg1.activeCount()];
				tg1.enumerate(threads);

				Arrays.asList(threads).forEach(System.out::println);
				System.out.println("---------------------------");
			}
		};

		t2.start();

	}

}
