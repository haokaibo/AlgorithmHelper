/**
 * 
 */
package com.effectivejava.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.effectivejava.classinterface.ForwardingSet;

/**
 * @author u0149807
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

	private final List<SetObserver<E>> observers = new ArrayList<SetObserver<E>>();

	public void addObserver(SetObserver<E> observer) {
		synchronized (observers) {
			observers.add(observer);
		}
	}

	public boolean removeObserver(SetObserver<E> observer) {
		synchronized (observers) {
			return observers.remove(observer);
		}
	}

	private void notifyElementAdded(E element) {
		synchronized (observers) {
			for (SetObserver<E> observer : observers)
				observer.added(this, element);
		}
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
}
