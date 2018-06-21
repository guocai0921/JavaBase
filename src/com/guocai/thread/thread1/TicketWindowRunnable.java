package com.guocai.thread.thread1;

/**
 * java类简单作用描述
 *
 * @ProjectName: J2EE
 * @Package: com.guocai.thread1
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 8:50
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class TicketWindowRunnable implements Runnable{

	private static final int MAX = 50;
	private int index = 1;

	@Override
	public void run() {
		while(index <= MAX){
			System.out.println("当前柜台："+Thread.currentThread().getName()+"-当前号码："+index++);
		}
	}
}
