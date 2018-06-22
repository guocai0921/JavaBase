package com.guocai.thread.thread5;

import java.util.Arrays;
import java.util.List;

/**
 * java类简单作用描述
 *
 * @ProjectName: JavaBase
 * @Package: com.guocai.thread.thread5
 * @Description: < 结束线程的方式2 >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/22 8:14
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class ThreadCloseGraceful2 {


	private static class Worker extends Thread{

		@Override
		public void run() {


			/*while (true) {
				try {
					Thread.sleep(1_000L);
					System.out.println("Hello");
				} catch (InterruptedException e) {
					break;//使用break后面的语句还可以执行
					//return;//使用return后面的语句将无法在执行
				}
			}*/
			while (true) {
				if (Thread.interrupted())
					break;
			}

			Arrays.asList("JAVA","C","PHP").forEach(System.out::println);

		}
	}

	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.start();

		try {
			Thread.sleep(3_000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		worker.interrupt();
	}

}
