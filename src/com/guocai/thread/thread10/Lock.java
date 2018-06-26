package com.guocai.thread.thread10;

import java.util.Collection;

/**
 * java类简单作用描述
 *
 * @ClassName: Lock
 * @Package: com.guocai.thread.thread10
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/26 8:33
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public interface Lock {

	class TimeOutException extends Exception{
		public TimeOutException(String message) {
			super(message);
		}
	}

	void lock() throws InterruptedException;

	void lock(long mills) throws InterruptedException,TimeOutException;

	void unlock();

	Collection<Thread> getBolckThreads();

	int getBlockThreadSize();

}
