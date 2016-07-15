package com.doctor.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description
 *
 * @author sdcuike
 *
 * @date 2016年7月15日 下午6:58:09
 */
public class ThreadRejectedExecutionException {

	public static void main(String[] args) throws InterruptedException {

		int maximumPoolSize = 2;
		int corePoolSize = 2;
		ExecutorService threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 0, TimeUnit.MICROSECONDS,
				new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.AbortPolicy());
		threadPool.submit(new Runnable() {

			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(10);
					System.out.println("over 1");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		threadPool.submit(new Runnable() {
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(10);
					System.out.println("over 2");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		threadPool.submit(new Runnable() {
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(10);
					System.out.println("over 3");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		TimeUnit.MINUTES.sleep(1);

		threadPool.shutdown();
	}

}
