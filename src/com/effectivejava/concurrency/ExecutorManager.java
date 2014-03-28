/**
 * 
 */
package com.effectivejava.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author u0149807
 *
 */
public class ExecutorManager {

	// Simple framework for timing concurrent execution
	public static long time(Executor executor, int concurrency,
			final Runnable action) throws InterruptedException {
		final CountDownLatch ready = new CountDownLatch(concurrency);
		final CountDownLatch start = new CountDownLatch(1);
		final CountDownLatch done = new CountDownLatch(concurrency);
		for (int i = 0; i < concurrency; i++) {
			executor.execute(new Runnable() {
				public void run() {
					ready.countDown(); // Tell timer we're ready
					try {
						start.await(); // Wait till peers are ready
						action.run();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					} finally {
						done.countDown(); // Tell timer we're done
					}
				}
			});
		}
		ready.await(); // Wait for all workers to be ready
		long startNanos = System.nanoTime();
		start.countDown(); // And they're off!
		done.await(); // Wait for all workers to finish
		return System.nanoTime() - startNanos;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			long executedTime = time(new ThreadPoolExecutor(1, 2, 10,
					TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>()),
					2, new Runnable() {
						@Override
						public void run() {
							System.out.printf("Runing %s%n", Thread.currentThread());
						}

					});
			System.out.printf("%sns %.3fms %.3fs", executedTime,
					executedTime / 1000.0, executedTime / 1000000.0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
