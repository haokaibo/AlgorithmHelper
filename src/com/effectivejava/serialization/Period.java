/**
 * 
 */
package com.effectivejava.serialization;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Kaibo Hao Immutable class that uses defensive copying
 */
public final class Period implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5418978383476004143L;
	private Date start;
	private Date end;

	/**
	 * @param start
	 *            the beginning of the period
	 * @param end
	 *            the end of the period; must not precede start
	 * @throws IllegalArgumentException
	 *             if start is after end
	 * @throws NullPointerException
	 *             if start or end is null
	 */
	public Period(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		if (this.start.compareTo(this.end) > 0)
			throw new IllegalArgumentException(start + " after " + end);
	}

	public Date start() {
		return new Date(start.getTime());
	}

	public Date end() {
		return new Date(end.getTime());
	}

	public String toString() {
		return start + " - " + end;
	}

	// Remainder omitted

	// readObject method with defensive copying and validity checking
	private void readObject(ObjectInputStream s) throws IOException,
			ClassNotFoundException {
		s.defaultReadObject();
		// Defensively copy our mutable components
		start = new Date(start.getTime());
		end = new Date(end.getTime());
		// Check that our invariants are satisfied
		if (start.compareTo(end) > 0)
			throw new InvalidObjectException(start + " after " + end);
	}
}
