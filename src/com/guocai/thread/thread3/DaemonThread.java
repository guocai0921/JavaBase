package com.guocai.thread.thread3;

/**
 * java类简单作用描述
 *
 * @ProjectName: J2EE
 * @Package: com.guocai.thread.thread3
 * @Description: < 守护线程 >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 13:50
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class DaemonThread {

	public static void main(String[] args) {

		Thread t = new Thread(()->{
			try {
				System.out.println(Thread.currentThread().getName()+" is begin...");
				Thread.sleep(15_000L);
				System.out.println(Thread.currentThread().getName()+" is done...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		t.setDaemon(true);
		t.start();
		try {
			Thread.sleep(10_000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());

	}

}
