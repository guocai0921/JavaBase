package com.guocai.thread.thread3;

import java.util.Optional;

/**
 * java类简单作用描述
 *
 * @ProjectName: JavaBase
 * @Package: com.guocai.thread.thread3
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 15:17
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class ThreadSimpleAPI {

	public static void main(String[] args) {
		Thread t = new Thread(()-> {
			for (int i = 0; i < 1000; i++) {
				Optional.of("Hello=>"+Thread.currentThread().getName()+"<-->"+i).ifPresent(System.out::println);
			}

		},"MyThread");
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();

		Thread t2 = new Thread(()-> {
			for (int i = 1000; i < 2000; i++) {
				Optional.of("Hi=>"+Thread.currentThread().getName()+"<-->"+i).ifPresent(System.out::println);
			}

		},"MyThread1");
		t2.setPriority(Thread.NORM_PRIORITY);
		t2.start();


		Thread t3 = new Thread(()-> {
			for (int i = 2000; i < 3000; i++) {
				Optional.of("yee=>" +Thread.currentThread().getName()+"<-->"+i).ifPresent(System.out::println);
			}

		},"MyThread2");
		t3.setPriority(Thread.MIN_PRIORITY);
		t3.start();

		int i = 5;
		if (i>6){
			idTest();
		}
	}

	private static void idTest() {
		Thread t = new Thread(()-> {

			Optional.of("Hello").ifPresent(System.out::println);
			try {
				Thread.sleep(1_000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		},"MyThread");

		t.start();

		Optional.of(t.getName()).ifPresent(System.out::println);
		Optional.of(t.getId()).ifPresent(System.out::println);
		Optional.of(t.getPriority()).ifPresent(System.out::println);
	}

}
