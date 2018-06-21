package com.guocai.thread.thread4;


import java.time.Duration;
import java.time.Instant;

/**
 * java类简单作用描述
 *
 * @ProjectName: JavaBase
 * @Package: com.guocai.thread.thread4
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/21 16:15
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class CaptureRunnable implements Runnable {

	private String machineName;
	private long speedTime;

	public CaptureRunnable(String machineName, long speedTime) {
		this.machineName = machineName;
		this.speedTime = speedTime;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(speedTime);
			System.out.println(machineName+"completed capture data finish and Successful!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getResult(){
		return machineName+"finish.";
	}

	public static void main(String[] args) throws InterruptedException {
		Instant startTime = Instant.now();
		Thread t1 = new Thread(new CaptureRunnable("M1 ->",10_000));
		Thread t2 = new Thread(new CaptureRunnable("M2 ->",30_000));
		Thread t3 = new Thread(new CaptureRunnable("M3 ->",15_000));
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		Instant endTime = Instant.now();
		long l = Duration.between(startTime, endTime).toMillis();
		System.out.println(l);
		System.out.printf(":%s",l);
	}

}
