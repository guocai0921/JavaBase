package com.guocai.thread.thread12;

import java.util.Arrays;

/**
 * java类简单作用描述
 *
 * @ClassName: ThreadGroupAPI
 * @Package: com.guocai.thread.thread12
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/27 9:43
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class ThreadGroupAPI {
	public static void main(String[] args) {

		ThreadGroup tg1 = new ThreadGroup("TG1");
		Thread t1 = new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(1_000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t1.start();
		ThreadGroup tg2 = new ThreadGroup("TG2");

		Thread t2 = new Thread(tg2,"T2"){
			@Override
			public void run() {

			}
		};

		t2.start();
	}
}
