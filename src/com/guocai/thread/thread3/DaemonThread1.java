package com.guocai.thread.thread3;

/**
 * java类简单作用描述
 *
 * @ProjectName: JavaBase
 * @Package: com.guocai.thread.thread3
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 14:57
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class DaemonThread1 {

	public static void main(String[] args) {
		Thread thread = new Thread(()->{
			Thread thread1 = new Thread(()->{
				try {
					Thread.sleep(10_000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			thread1.setDaemon(true);
			thread1.start();
			try {
				Thread.sleep(1_000L);
				System.out.println("T Thread finished done");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		thread.setDaemon(true);
		thread.start();
	}


}
