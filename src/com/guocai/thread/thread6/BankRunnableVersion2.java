package com.guocai.thread.thread6;

/**
 * java类简单作用描述
 *
 * @ProjectName: J2EE
 * @Package: com.guocai.thread1
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 8:52
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class BankRunnableVersion2 {
	public static void main(String[] args) {
		TicketWindowRunnable twr = new TicketWindowRunnable();
		Thread t1 = new Thread(twr,"壹号柜台机");
		Thread t2 = new Thread(twr,"贰号柜台机");
		Thread t3 = new Thread(twr,"叁号柜台机");
		t1.start();
		t2.start();
		t3.start();
	}
}
