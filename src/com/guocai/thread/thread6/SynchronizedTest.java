package com.guocai.thread.thread6;

/**
 * java类简单作用描述
 *
 * @ClassName: SynchronizedTest
 * @Package: com.guocai.thread.thread6
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/22 11:18
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class SynchronizedTest {

	private final static Object LOCK = new Object();

	public static void main(String[] args) {
		Runnable runnable = () -> {
			synchronized (LOCK) {
				try {
					Thread.sleep(100_000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		Thread t3 = new Thread(runnable);
		t1.start();
		t2.start();
		t3.start();
	}

}
