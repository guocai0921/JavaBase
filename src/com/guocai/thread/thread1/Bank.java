package com.guocai.thread.thread1;

/**
 * java类简单作用描述
 *
 * @ProjectName: J2EE
 * @Package: com.guocai.thread1
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 8:35
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class Bank {
	public static void main(String[] args) {

		/**
		 * 使用static关键字实现变量的唯一的一份实例，实现多线程公用一份数据
		 */
		TicketWindow t1 = new TicketWindow("壹号柜台机");
		t1.start();
		TicketWindow t2 = new TicketWindow("贰号柜台机");
		t2.start();
		TicketWindow t3 = new TicketWindow("叁号柜台机");
		t3.start();
		TicketWindow t4 = new TicketWindow("肆号柜台机");
		t4.start();
	}
}
