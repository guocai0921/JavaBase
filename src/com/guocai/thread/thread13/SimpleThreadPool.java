package com.guocai.thread.thread13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * java类简单作用描述
 *
 * @ClassName: SimpleThreadPool
 * @Package: com.guocai.thread.thread13
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/27 10:06
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class SimpleThreadPool {

	private final int size;

	private final static int DEFAULT_SIZE = 10;

	private final static int DEFAULT_TASK_QUEUE_SIZE = 2000;

	private static volatile int seq = 0;

	private static final String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";

	private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");

	//定义任务队列
	private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

	private final static List<WorkerTask> THREAD_QUEUE = new ArrayList<>();

	private final int queueSize;

	private volatile boolean destroy = false;

	private final DiscardPolicy discardPolicy;

	public final static DiscardPolicy DEFAULT_DISCARD_POLICY =  ()->{
		throw new DiscardException("");
	};

	public SimpleThreadPool(){
		this(DEFAULT_SIZE,DEFAULT_TASK_QUEUE_SIZE,DEFAULT_DISCARD_POLICY);
	}

	public SimpleThreadPool(int size,int queueSize,DiscardPolicy discardPolicy){
		this.size = size;
		this.queueSize = queueSize;
		this.discardPolicy = discardPolicy;
		init();
	}

	private void init() {
		for (int i = 0; i < size; i++) {
			createWokeTask();
		}
	}

	public void submit(Runnable runnable){

		if(destroy){
			throw new IllegalStateException("The thread pool already destroy and not allow submit task.");
		}

		synchronized (TASK_QUEUE) {
			if (TASK_QUEUE.size() > queueSize){
				discardPolicy.discard();
			}
			TASK_QUEUE.addLast(runnable);
			TASK_QUEUE.notifyAll();
		}
	}

	private void createWokeTask(){
		WorkerTask task = new WorkerTask(GROUP,THREAD_PREFIX+(seq++));
		task.start();
		THREAD_QUEUE.add(task);
	}

	//定义线程状态
	private enum TaskState{
		FREE,RUNNING,BLOCKED,DEAD
	}

	public static class DiscardException extends RuntimeException{
		public DiscardException(String message){
			super(message);
		}
	}

	public interface DiscardPolicy{
		void discard() throws DiscardException;
	}


	private static class WorkerTask extends Thread{
		private volatile TaskState taskState = TaskState.FREE;
		private volatile boolean destroy;

		public WorkerTask(ThreadGroup group,String name){
			super(group,name);
		}

		public TaskState getTaskState(){
			return this.taskState;
		}

		public void run(){
			OUTER:
			while (this.taskState != TaskState.DEAD){
				Runnable runnable;
				synchronized (TASK_QUEUE){
					while (TASK_QUEUE.isEmpty()){
						try {
							taskState = TaskState.BLOCKED;
							TASK_QUEUE.wait();
						} catch (InterruptedException e) {
							break OUTER;
						}
					}
				}
				runnable = TASK_QUEUE.removeFirst();
				if(runnable!=null){
					taskState = TaskState.RUNNING;
					runnable.run();
					taskState = TaskState.FREE;
				}
			}
		}

		public void close(){
			this.taskState = TaskState.DEAD;
		}

		public void shutdown() throws InterruptedException{
			while (!TASK_QUEUE.isEmpty()) {
				Thread.sleep(50L);
			}

			int initVal = THREAD_QUEUE.size();
			while (initVal>0){
				for (WorkerTask task:THREAD_QUEUE){
					if(task.getTaskState() == TaskState.BLOCKED){
						task.interrupt();
						task.close();
						initVal--;
					}else{
						Thread.sleep(10L);
					}
				}
			}
			this.destroy = true;
			System.out.println("The thread pool disposed");
		}

	}

	public int getSize() {
		return size;
	}

	public int getQueueSize() {
		return queueSize;
	}

	public boolean destroy(){
		return this.destroy;
	}

	public static void main(String[] args) {
		SimpleThreadPool simpleThreadPool = new SimpleThreadPool(6,10,SimpleThreadPool.DEFAULT_DISCARD_POLICY);

		for (int i = 0; i < 40; i++) {
			simpleThreadPool.submit(() ->{
				System.out.println("The runnable  be serviced by "+Thread.currentThread()+" start...");
				try {
					Thread.sleep(3_000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("The runnable be serviced by "+Thread.currentThread()+" finished...");
			});
		}
	}

}
