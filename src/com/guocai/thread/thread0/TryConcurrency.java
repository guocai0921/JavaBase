package com.guocai.thread.thread0;

/**
 * java类简单作用描述
 *
 * @ProjectName: J2EE
 * @Package: com.guocai.thread0
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/20 17:01
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class TryConcurrency {

	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getName());

		/*Thread t1 = new Thread("myt1"){
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("i->"+i);
				}
			}
		};

		t1.start();



		for (int j = 0; j < 100; j++) {
			System.out.println("j->"+j);
		}*/

		/*try {
			Thread.sleep(1000*120L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/

		/*Instant it1 = Instant.now();
		readFromDataBase();
		writeDataToFile();
		Instant it2 = Instant.now();
		long l = Duration.between(it1, it2).toMillis();
		System.out.println(l);*/


		new Thread(() -> readFromDataBase(),"t1").start();
		new Thread(() -> writeDataToFile(), "t2").start();
	}

	private static void readFromDataBase(){
		try {
			println("begin read data from DB...");
			Thread.sleep(1000*10L);
			println("read data done and start handle it...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		println("The data handle finish and successfully...");
	}

	private static void writeDataToFile(){
		try {
			println("begin write data from DB...");
			Thread.sleep(1000*10L);
			println("write data done and start handle it...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		println("The data handle finish and successfully...");
	}

	private static void println(String message){
		System.out.println(message);
	}


}
