package com.guocai.thread.thread4;

import java.util.stream.IntStream;

/**
 * java类简单作用描述
 *
 * @ProjectName: JavaBase
 * @Package: com.guocai.thread.thread4
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 15:50
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class ThreadJoin {
	public static void main(String[] args) {
		Thread t = new Thread(() -> IntStream.range(1, 1000).forEach((i) -> System.out.println(Thread.currentThread().getName() + i)), "SubThread");
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		IntStream.range(1, 1000).forEach((i) -> System.out.println(Thread.currentThread().getName() + i));
	}
}
