package com.guocai.thread.thread10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * java类简单作用描述
 *
 * @ClassName: BooleanLock
 * @Package: com.guocai.thread.thread10
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/26 8:37
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class BooleanLock implements Lock {

	//The initValue is true indicated the lock have be get ...
	//The initValue is false indicated the lock is free (other thread can get this.)
	private boolean initValue;

	private Collection<Thread> blockedThreadCollention = new ArrayList<>();

	public BooleanLock() {
		this.initValue = false;
	}

	private Thread currentThread;

	@Override
	public synchronized void lock() throws InterruptedException {
		while (initValue) {
			blockedThreadCollention.add(Thread.currentThread());
			this.wait();
		}
		this.initValue = true;
		blockedThreadCollention.remove(Thread.currentThread());
		currentThread = Thread.currentThread();
	}

	@Override
	public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
		if (mills <=0) {
			lock();
		}
		long hasRemaining = mills;
		long endTime = System.currentTimeMillis() + mills;
		while (initValue) {
			if (hasRemaining <=0) {
				throw new TimeOutException("Time out");
			}
			blockedThreadCollention.add(Thread.currentThread());
			this.wait(mills);
			hasRemaining = endTime - System.currentTimeMillis();
		}
		this.initValue = true;
		currentThread = Thread.currentThread();
	}

	@Override
	public synchronized void unlock() {
		if (Thread.currentThread() == currentThread) {
			this.initValue = false;
			Optional.of(Thread.currentThread().getName()+" release the lock monitor.").ifPresent(System.out::println);
			this.notifyAll();
		}
	}

	@Override
	public Collection<Thread> getBolckThreads() {
		return Collections.unmodifiableCollection(blockedThreadCollention);
	}

	@Override
	public int getBlockThreadSize() {
		return 0;
	}
}
