package com.guocai.thread.thread1;

/**
 * java类简单作用描述
 *
 * @ProjectName: J2EE
 * @Package: com.guocai.thread1
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 8:34
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class TicketWindow extends Thread{

	private final String name;
	private static final int MAX = 50;
	private static int index = 1;

	public TicketWindow(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while(index <= MAX){
			System.out.println("当前柜台："+name+"-当前号码："+index);
			index++;
		}
	}
}
