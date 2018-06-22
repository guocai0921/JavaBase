package com.guocai.thread.thread8;

/**
 * java类简单作用描述
 *
 * @ClassName: ProduceConsumerVersion1
 * @Package: com.guocai.thread.thread8
 * @Description: < 线程之间的通信：wait() >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/22 14:59
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class ProduceConsumerVersion1 {

	private int i = 1;

	private final Object LOCK = new Object();

	private void produce(){
		synchronized (LOCK) {
			System.out.println("P->"+i++);
		}
	}
	private void consumer(){
		synchronized (LOCK) {
			System.out.println("C->"+ --i);
		}
	}

	public static void main(String[] args) {
		ProduceConsumerVersion1 psv = new ProduceConsumerVersion1();
		new Thread(()->{
			while (true) {
				psv.produce();
			}
		}).start();
		new Thread(()->{
			while (true) {
				psv.consumer();
			}
		}).start();
	}

}
