package com.guocai.thread.thread6;

import java.time.Duration;
import java.time.Instant;

/**
 * java类简单作用描述
 *
 * @ClassName: SynchronizedThis
 * @Package: com.guocai.thread.thread6
 * @Description: < This锁 >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/22 13:50
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class SynchronizedThis {

	public static void main(String[] args) {
		ThisLock thisLock = new ThisLock();
		new Thread(() -> thisLock.m3(),"T1").start();
		new Thread(() -> thisLock.m4(),"T2").start();
	}
}

class ThisLock{

	private static final Object LOCK = new Object();

	public synchronized void m1(){
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(10_000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void m2(){
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(10_000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void m3(){
		synchronized (LOCK) {
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(10_000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void m4(){
		synchronized (LOCK) {
			Instant start = Instant.now();
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(10_000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Instant end = Instant.now();
			Long mills_value = Duration.between(start, end).toMillis();
			System.out.println("mills_value = " + mills_value);
		}
	}

}
