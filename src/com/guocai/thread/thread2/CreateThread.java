package com.guocai.thread.thread2;

/**
 * java类简单作用描述
 *
 * @ProjectName: J2EE
 * @Package: com.guocai.thread2
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 9:43
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class CreateThread {
	public static void main(String[] args) {
		Thread t = new Thread();
		t.start();
		System.out.println(t.getName());
		Thread t1 = new Thread();
		t1.start();
		System.out.println(t1.getName());


		Thread t2 = new Thread(()-> System.out.println("HelloWorld"));
		t2.start();
		System.out.println(t2.getName());

		Thread t3 = new Thread("MyThread");
		t3.start();
		System.out.println(t3.getName());


		Thread t4 = new Thread(()-> System.out.println("HelloWorld!!!"),"This is Me");
		t4.start();
		System.out.println(t4.getName());
	}
}
