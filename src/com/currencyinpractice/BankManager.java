/**
 * 
 */
package com.currencyinpractice;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Kaibo
 * 
 */
public class BankManager {
	private static final TimeUnit NANOSECONDS = TimeUnit.NANOSECONDS;
	private static final Random rnd = new Random();
	private final Lock lock = new ReentrantLock();

	public boolean transferMoney(Account fromAcct, Account toAcct,
			DollarAmount amount, long timeout, TimeUnit unit)
			throws InsufficientFundsException, InterruptedException {
		long fixedDelay = getFixedDelayComponentNanos(timeout, unit);
		long randMod = getRandomDelayModulusNanos(timeout, unit);
		long stopTime = System.nanoTime() + unit.toNanos(timeout);
		while (true) {
			if (fromAcct.lock.tryLock()) {
				try {
					if (toAcct.lock.tryLock()) {
						try {
							if (fromAcct.getBalance().compareTo(amount) < 0)
								throw new InsufficientFundsException();
							else {
								fromAcct.debit(amount);
								toAcct.credit(amount);
								return true;
							}
						} finally {
							toAcct.lock.unlock();
						}
					}
				} finally {
					fromAcct.lock.unlock();
				}
			}
			if (System.nanoTime() < stopTime)
				return false;

			NANOSECONDS.sleep(fixedDelay + rnd.nextLong() % randMod);
		}
	}

	public boolean trySendOnSharedLine(String message, long timeout,
			TimeUnit unit) throws InterruptedException {
		long nanosToLock = unit.toNanos(timeout)
				- estimatedNanosToSend(message);
		if (!lock.tryLock(nanosToLock, NANOSECONDS))
			return false;
		try {
			return sendOnSharedLine(message);
		} finally {
			lock.unlock();
		}
	}

	/**
	 * @param message
	 * @return
	 */
	public boolean sendOnSharedLine(String message) throws InterruptedException {
		lock.lockInterruptibly();
		try {
			return cancellableSendOnSharedLine(message);
		} finally {
			lock.unlock();
		}
	}

	private boolean cancellableSendOnSharedLine(String message)
			throws InterruptedException {
		return true;
	}

	/**
	 * @param message
	 * @return
	 */
	private long estimatedNanosToSend(String message) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param timeout
	 * @param unit
	 * @return
	 */
	private long getRandomDelayModulusNanos(long timeout, TimeUnit unit) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param timeout
	 * @param unit
	 * @return
	 */
	private long getFixedDelayComponentNanos(long timeout, TimeUnit unit) {
		// TODO Auto-generated method stub
		return 0;
	}
}
