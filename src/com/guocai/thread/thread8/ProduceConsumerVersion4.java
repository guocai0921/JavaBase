package com.guocai.thread.thread8;

import java.util.stream.Stream;

/**
 * java类简单作用描述
 *
 * @ClassName: ProduceConsumerVersion2
 * @Package: com.guocai.thread.thread8
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/22 15:12
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class ProduceConsumerVersion4 {

	private int i = 0;
	final private Object LOCK = new Object();
	private volatile boolean isProduced = false;
	public void produce(){
		synchronized (LOCK) {
			while(isProduced){
				try {
					LOCK.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			i++;
			System.out.println("Pr->"+i);
			LOCK.notifyAll();
			isProduced = true;

		}
	}

	public void consumer(){
		synchronized (LOCK) {
			while (!isProduced) {
				try {
					LOCK.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Co->"+i);
			LOCK.notifyAll();
			isProduced = false;

		}
	}

	public static void main(String[] args) {

		ProduceConsumerVersion4 psv = new ProduceConsumerVersion4();
		Stream.of("P1","P2").forEach(n->
			new Thread(()->{
				while (true) {
					psv.consumer();
					try {
						Thread.sleep(10L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start()
		);
		Stream.of("C1","C2").forEach(n->
			new Thread(()->{
				while (true) {
					psv.produce();
					try {
						Thread.sleep(10L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start()
		);
	}

}
