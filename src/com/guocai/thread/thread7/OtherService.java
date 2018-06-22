package com.guocai.thread.thread7;

/**
 * java类简单作用描述
 *
 * @ClassName: OtherService
 * @Package: com.guocai.thread.thread6
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/22 14:24
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class OtherService {

	private final Object LOCK = new Object();

	private DeadLock deadLock;

	public void f1(){
		synchronized (LOCK) {
			System.out.println("f1...");
		}
	}

	public void f2(){
		synchronized (LOCK) {
			deadLock.m2();
			System.out.println("f2....");
		}
	}

	public void setDeadLock(DeadLock deadLock) {
		this.deadLock = deadLock;
	}
}
