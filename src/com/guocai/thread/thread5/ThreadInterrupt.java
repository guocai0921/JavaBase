package com.guocai.thread.thread5;

/**
 * java类简单作用描述
 *
 * @ProjectName: JavaBase
 * @Package: com.guocai.thread
 * @Description: < interrupt方法测试 >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 16:43
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class ThreadInterrupt {

	private static final Object obj = new Object();

	public static void main(String[] args) throws Exception {
		//testInterrupt();
		//testStaticInterrupt();

		Thread t1 = new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(10_000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		t1.start();

		Thread t2 = new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				t1.interrupt();
			}
		};

		t2.start();
		t1.join();
	}

	private static void testStaticInterrupt() {
		Thread t1 = new Thread(){
			@Override
			public void run() {
				while(true){

					synchronized (obj){
						try {
							obj.wait(10L);
						} catch (InterruptedException e) {
							e.printStackTrace();
							System.out.println(Thread.interrupted());
						}
					}

				}
			}
		};

		t1.start();
	}

	private static void testInterrupt() throws InterruptedException {
		Thread t1 = new Thread(){
			@Override
			public void run() {
				while(true){

					synchronized (obj){
						try {
							obj.wait(10L);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					/*try {
						Thread.sleep(10L);
					} catch (InterruptedException e) {
						System.out.println("收到打断信号!!!");
						e.printStackTrace();
					}*/
				}
			}
		};

		t1.start();

		Thread.sleep(100L);
		System.out.println(t1.isInterrupted());
		t1.interrupt();
		System.out.println(t1.isInterrupted());

		//t1.stop();
	}
}
