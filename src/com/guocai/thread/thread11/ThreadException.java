package com.guocai.thread.thread11;

/**
 * java类简单作用描述
 *
 * @ClassName: ThreadException
 * @Package: com.guocai.thread.thread11
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/26 16:16
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class ThreadException {

	private final static int A = 10;
	private final static int B = 0;

	public static void main(String[] args) {
		Thread t = new Thread(()->{
			try {
				Thread.sleep(5_000L);
				int result = A/B;
				System.out.println(result);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		t.setUncaughtExceptionHandler((thread,e)->{
			System.out.println(thread);
			System.out.println(e);
		});

		t.start();

	}

}
