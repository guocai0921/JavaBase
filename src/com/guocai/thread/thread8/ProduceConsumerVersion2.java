package com.guocai.thread.thread8;

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
public class ProduceConsumerVersion2 {

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
				System.out.println("P->"+i);
				LOCK.notify();
				isProduced = true;
			}
		}
	}

	public void consumer(){
		synchronized (LOCK) {
			if(isProduced){
				System.out.println("C->"+i);
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
		ProduceConsumerVersion2 psv = new ProduceConsumerVersion2();
		new Thread(()->{
			while (true) {
				psv.consumer();
			}
		}).start();
		new Thread(()->{
			while (true) {
				psv.produce();
			}
		}).start();
	}

}
