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
public class ProduceConsumerVersion3 {

	private int i = 0;
	final private Object LOCK = new Object();
	private volatile boolean isProduced = false;
	public void produce(){
		synchronized (LOCK) {
			if(isProduced){
				try {
					LOCK.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				i++;
				System.out.println("Pro->"+i);
				LOCK.notify();
				isProduced = true;
			}
		}
	}

	public void consumer(){
		synchronized (LOCK) {
			if(isProduced){
				System.out.println("Con->"+i);
				LOCK.notify();
				isProduced = false;
			} else {
				try {
					LOCK.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		//多生产者和多消费者，易发生全部在wait()中，发生假死现象
		ProduceConsumerVersion3 psv = new ProduceConsumerVersion3();
		Stream.of("P1","P2").forEach(n->
			new Thread(()->{
				while (true) {
					psv.consumer();
				}
			}).start()
		);
		Stream.of("C1","C2").forEach(n->
			new Thread(()->{
				while (true) {
					psv.produce();
				}
			}).start()
		);
	}

}
