package com.guocai.thread.thread6;

/**
 * java类简单作用描述
 *
 * @ClassName: SynchronizedRunnable
 * @Package: com.guocai.thread.thread6
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/22 12:27
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class SynchronizedRunnable implements Runnable {
	private static final int MAX = 500;
	private int index = 1;

	private final Object obj = new Object();

	@Override
	public void run() {
		while (true) {
			if (ticket()) {
				break;
			}
		}
	}

	/*@Override
	public synchronized void run() {
		while(true){

			if (index <= MAX) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("当前柜台："+Thread.currentThread().getName()+"-当前号码："+index++);
			}

		}
	}*/


	/*private synchronized boolean ticket() {
		if (index > MAX) {
			return true;
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("当前柜台：" + Thread.currentThread().getName() + "-当前号码：" + index++);
		return false;

	}*/

	private boolean ticket() {

		synchronized(this){
			if (index > MAX) {
				return true;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("当前柜台：" + Thread.currentThread().getName() + "-当前号码：" + index++);
			return false;
		}

	}

}
