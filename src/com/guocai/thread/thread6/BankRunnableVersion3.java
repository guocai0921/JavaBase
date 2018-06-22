package com.guocai.thread.thread6;

/**
 * java类简单作用描述
 *
 * @ClassName: BankRunnableVersion1
 * @Package: com.guocai.thread.thread6
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/22 12:31
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class BankRunnableVersion3 {


	public static void main(String[] args) {

		SynchronizedRunnable twr = new SynchronizedRunnable();
		Thread t1 = new Thread(twr,"壹号柜台机");
		Thread t2 = new Thread(twr,"贰号柜台机");
		Thread t3 = new Thread(twr,"叁号柜台机");

		t1.start();
		t2.start();
		t3.start();
	}
}
