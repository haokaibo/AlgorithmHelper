/**
 * Demo for "67 Avoid excessive synchronization".
 */
package com.effectivejava.concurrency;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.effectivejava.classinterface.ForwardingSet;

/**
 * @author Kaibo Hao
 * 
 */
public class ObservableSet<E> extends ForwardingSet<E> {

	/**
	 * @param s
	 */
	public ObservableSet(Set<E> s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	// Thread-safe observable set with CopyOnWriteArrayList
	private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<SetObserver<E>>();

	public void addObserver(SetObserver<E> observer) {
		observers.add(observer);
	}

	public boolean removeObserver(SetObserver<E> observer) {
		return observers.remove(observer);
	}

	private void notifyElementAdded(E element) {
		for (SetObserver<E> observer : observers)
			observer.added(this, element);
	}

	@Override
	public boolean add(E element) {
		boolean added = super.add(element);
		if (added)
			notifyElementAdded(element);
		return added;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean result = false;
		for (E element : c)
			result |= add(element); // calls notifyElementAdded
		return result;
	}

	public static void main(String[] args) {
		ObservableSet<Integer> set = new ObservableSet<Integer>(
				new HashSet<Integer>());
		set.addObserver(new SetObserver<Integer>() {
			@Override
			public void added(final ObservableSet<Integer> s, Integer e) {
				System.out.println(e);
				if (e == 23) {
					ExecutorService executor = Executors
							.newSingleThreadExecutor();
					final SetObserver<Integer> observer = this;
					try {
						executor.submit(new Runnable() {
							@Override
							public void run() {
								s.removeObserver(observer);
							}
						}).get();
					} catch (ExecutionException ex) {
						throw new AssertionError(ex.getCause());
					} catch (InterruptedException ex) {
						throw new AssertionError(ex.getCause());
					} finally {
						executor.shutdown();
					}
				}
			}
		});
		for (int i = 0; i < 100; i++)
			set.add(i);
	}
}
