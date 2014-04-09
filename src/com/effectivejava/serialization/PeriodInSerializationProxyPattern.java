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
 * @author Kaibo
 * 
 */
public class PeriodInSerializationProxyPattern implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -691471346212508401L;
	/**
	 * The serialization Version UID of the Period class.
	 */
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
	public PeriodInSerializationProxyPattern(Date start, Date end) {
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
	private void readObject(ObjectInputStream s) throws InvalidObjectException {
		throw new InvalidObjectException("Proxy required");

	}

	// Serialization proxy for Period class
	private static class SerializationProxy implements Serializable {
		private final Date start;
		private final Date end;

		SerializationProxy(PeriodInSerializationProxyPattern p) {
			this.start = p.start;
			this.end = p.end;
		}

		// Any number will do (Item 75)
		private static final long serialVersionUID = 234098243823485285L;
	}

	// writeReplace method for the serialization proxy pattern
	private Object writeReplace() {
		return new SerializationProxy(this);
	}

	// readResolvemethod for Period.SerializationProxy
	private Object readResolve() {
		return new PeriodInSerializationProxyPattern(start, end); // Uses public
																	// constructor
	}

}
