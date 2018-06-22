package com.guocai.thread.thread6;

/**
 * java类简单作用描述
 *
 * @ProjectName: J2EE
 * @Package: com.guocai.thread1
 * @Description: < 使用synchronized代码块实现线程安全 >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 8:50
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class TicketWindowRunnable implements Runnable{

	private static final int MAX = 50;
	private int index = 1;

	private final Object obj = new Object();

	@Override
	public void run() {
		while(true){
			synchronized (obj) {
				if (index <= MAX) {
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("当前柜台："+Thread.currentThread().getName()+"-当前号码："+index++);
				}
			}
		}
	}
}
