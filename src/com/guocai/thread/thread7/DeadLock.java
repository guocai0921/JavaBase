package com.guocai.thread.thread7;

/**
 * java类简单作用描述
 *
 * @ClassName: DeadLock
 * @Package: com.guocai.thread
 * @Description: < 死锁:避免程序死锁：尽量在程序中避免使用层级锁 >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/22 14:23
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class DeadLock {

	private OtherService otherService;

	public DeadLock(OtherService otherService) {
		this.otherService = otherService;
	}

	private final Object LOCK = new Object();

	public  void m1(){
		synchronized(LOCK){
			otherService.f1();
			System.out.println("m1...");
		}
	}

	public void m2() {
		synchronized(LOCK){
			System.out.println("m2...");
		}
	}
}
