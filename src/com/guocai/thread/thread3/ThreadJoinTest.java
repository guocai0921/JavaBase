package com.guocai.thread.thread3;

/**
 * java类简单作用描述
 *
 * @ProjectName: JavaBase
 * @Package: com.guocai.thread.thread3
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 15:45
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class ThreadJoinTest {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("A");
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("B");
			}
		});

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("C");
			}
		});

		t1.start();
		t2.start();
		t3.start();
	}

}
