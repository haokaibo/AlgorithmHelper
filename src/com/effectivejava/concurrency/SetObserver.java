/**
 * Demo for "67 Avoid excessive synchronization".
 */
package com.effectivejava.concurrency;

/**
 * @author u0149807
 *
 */
public interface SetObserver<E> {
	// Invoked when an element is added to the observable set
	void added(ObservableSet<E> set, E element);
}
