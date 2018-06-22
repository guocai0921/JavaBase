package com.guocai.thread.thread7;

/**
 * java类简单作用描述
 *
 * @ClassName: DeadLockMain
 * @Package: com.guocai.thread.thread7
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/22 14:39
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class DeadLockMain {

	public static void main(String[] args) {
		OtherService otherService = new OtherService();
		DeadLock deadLock = new DeadLock(otherService);
		otherService.setDeadLock(deadLock);
		new Thread(()->{
			while (true) {
				deadLock.m1();
			}
		}).start();
		new Thread(()->{
			while (true) {
				otherService.f2();
			}
		}).start();
	}

}
