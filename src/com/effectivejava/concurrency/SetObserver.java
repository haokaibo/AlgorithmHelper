/**
 * Demo for "67 Avoid excessive synchronization".
 */
package com.effectivejava.concurrency;

/**
 * @author Kaibo Hao
 *
 */
public interface SetObserver<E> {
	// Invoked when an element is added to the observable set
	void added(ObservableSet<E> set, E element);
}
