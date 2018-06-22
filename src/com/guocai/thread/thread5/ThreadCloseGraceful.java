package com.guocai.thread.thread5;

/**
 * java类简单作用描述
 *
 * @ProjectName: JavaBase
 * @Package: com.guocai.thread.thread5
 * @Description: < 结束线程的方式1 >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/22 8:14
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class ThreadCloseGraceful {


	private static class Worker extends Thread{

		private volatile boolean flag = true;
		int num = 1;
		@Override
		public void run() {
			while(flag){
				try {
					Thread.sleep(1_000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(num);
				num++;
			}
		}

		public void shutdown(){
			this.flag = false;
		}
	}

	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.start();

		try {
			Thread.sleep(5_000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		worker.shutdown();

	}

}
