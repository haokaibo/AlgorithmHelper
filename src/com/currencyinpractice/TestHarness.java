/**
 * 
 */
package com.currencyinpractice;

import java.util.concurrent.CountDownLatch;

/**
 * @author Kaibo Hao
 *
 */
public class TestHarness {
	public long timeTasks(int nThreads, final Runnable task)
			throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);
		for (int i = 0; i < nThreads; i++) {
			Thread t = new Thread() {
				public void run() {
					try {
						startGate.await();
						try {
							task.run();
						} finally {
							endGate.countDown();
						}
					} catch (InterruptedException ignored) {
					}
				}
			};
			t.start();
		}
		long start = System.nanoTime();
		startGate.countDown();
		endGate.await();
		long end = System.nanoTime();
		return end - start;
	}

	public static void main(String[] args) {
		TestHarness th = new TestHarness();
		int nThreads = 3;
		try {
			System.out.printf("It take %d ns to finish %d tasks.",
					th.timeTasks(nThreads, new Runnable() {
						@Override
						public void run() {
							System.out.println("Run");
						}

					}), nThreads);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
