package com.guocai.thread.thread9;

import javax.naming.ldap.Control;
import java.util.*;

/**
 * java类简单作用描述
 *
 * @ClassName: CaptureService
 * @Package: com.guocai.thread.thread9
 * @Description: < Thread  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/25 11:08
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class CaptureService {

	final static private LinkedList<Control> CONTROLS = new LinkedList<>();

	public static void main(String[] args) {

		List<Thread> worker = new ArrayList<>();

		Arrays.asList("M1","M2","M3","M4","M5","M6","M7","M8","M9","M10")
				.stream().map(CaptureService::createCaptureThread)
				.forEach(t-> {
					t.start();
					worker.add(t);
				});
		worker.stream().forEach(t->{
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Optional.of("All capture is worker finished...").ifPresent(System.out::println);

	}

	private static Thread createCaptureThread(String name){
		return new Thread(()->{
			Optional.of("The worker ["+Thread.currentThread().getName()+"] BEGIN capture data ...")
				.ifPresent(System.out::println);
			synchronized (CONTROLS) {
				while (CONTROLS.size()>5) {
					try {
						CONTROLS.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				CONTROLS.addLast(new Control());
			}

			Optional.of("The worker ["+Thread.currentThread().getName()+"] is working...")
				.ifPresent(System.out::println);
			try {
				Thread.sleep(10_000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (CONTROLS) {
				Optional.of("The worker ["+Thread.currentThread().getName()+"] END capture data...")
					.ifPresent(System.out::println);
				CONTROLS.removeFirst();
				CONTROLS.notifyAll();
			}

		},name);
	}

	private static class Control{}

}
