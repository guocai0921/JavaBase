package com.guocai.thread.thread5;

import java.time.Duration;
import java.time.Instant;

/**
 * java类简单作用描述
 *
 * @ProjectName: JavaBase
 * @Package: com.guocai.thread.thread5
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/22 8:58
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class ThreadService {

	private Thread executeThread;

	private boolean flag = false;

	/**
	 * @Description:
	 * @auther: Sun Guocai
	 * @date:   2018/6/22 10:44
	 * @name:   execute
	 * @param:  [task]
	 * @return: void
	 *
	 */
	public void execute(Runnable task) {
		executeThread = new Thread() {
			@Override
			public void run() {
				Thread runner = new Thread(task);
				runner.setDaemon(true);
				runner.start();

				try {
					runner.join();
					flag = true;
				} catch (InterruptedException e) {
					//e.printStackTrace();
				}
			}
		};
		executeThread.start();
	}


	
	/**
	 * @Description:
	 * @auther: Sun Guocai
	 * @date:   2018/6/22 10:39
	 * @name:   shutdown
	 * @param:  [mills]
	 * @return: void
	 *
	 */
	public void shutdown(long mills) {
		long startTime = System.currentTimeMillis();

		while (!flag) {
			if ((System.currentTimeMillis()-startTime)>=mills){
				System.out.println("任务超时，需要结束他！");
				executeThread.interrupt();
				break;
			}
			try {
				executeThread.sleep(1L);
			} catch (InterruptedException e) {
				System.out.println("执行线程被打断！");
				break;
			}

		}
		flag = false;
	}

	public static void main(String[] args) {
		ThreadService service = new ThreadService();
		Instant start = Instant.now();
		service.execute(()->{
			/*while(true){

			}*/
			try {
				Thread.sleep(2_000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		service.shutdown(5_000L);
		Instant end = Instant.now();
		Long value = Duration.between(start, end).toMillis();
		System.out.println("value = " + value);


		

	}

}
