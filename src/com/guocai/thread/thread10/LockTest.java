package com.guocai.thread.thread10;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * java类简单作用描述
 *
 * @ClassName: LockTest
 * @Package: com.guocai.thread.thread10
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/26 8:53
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class LockTest {

	public static void main(String[] args) {
		final BooleanLock booleanLock = new BooleanLock();
		Stream.of("M1","T1","N1","B1")
				.forEach(name -> new Thread(()->{
					try {
						booleanLock.lock();
						work();
						Optional.of(Thread.currentThread().getName()+" have the lock monitor").ifPresent(System.out::println);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						booleanLock.unlock();
					}

				},name).start());
	}

	private static void work() throws InterruptedException{
		Optional.of(Thread.currentThread().getName() + " is Working ...")
				.ifPresent(System.out::println);
		Thread.sleep(3_000);
	}

}
