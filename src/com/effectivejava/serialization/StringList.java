/**
 * Demo for "75 Consider using a custom serialized form".
 */
package com.effectivejava.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @author Kaibo
 *
 */
public class StringList implements Serializable {
	/**
	 * The serial version UID of the object.
	 */
	private static final long serialVersionUID = 7533856777949584383L;
	private transient int size = 0;
	private transient Entry head = null;
	private transient Entry tail = null;

	// No longer Serializable!
	private static class Entry {
		String data;
		Entry next;
		@SuppressWarnings("unused")
		Entry previous;
	}

	// Appends the specified string to the list
	public final void add(String s) {
		Entry e = new Entry();
		e.data = s;
		if (null == head) {
			tail = head = e;
		} else {
			tail.next = e;
			tail.next.previous = tail;
			tail = tail.next;
		}
		size++;
	}

	/**
	 * Serialize this {@code StringList} instance.
	 *
	 * @serialData The size of the list (the number of strings it contains) is
	 *             emitted ({@code int}), followed by all of its elements (each
	 *             a {@code String}), in the proper sequence.
	 */
	private void writeObject(ObjectOutputStream s) throws IOException {
		s.defaultWriteObject();
		s.writeInt(size);
		// Write out all elements in the proper order.
		for (Entry e = head; e != null; e = e.next)
			s.writeObject(e.data);
	}

	private void readObject(ObjectInputStream s) throws IOException,
			ClassNotFoundException {
		s.defaultReadObject();
		int numElements = s.readInt();
		// Read in all elements and insert them in list
		for (int i = 0; i < numElements; i++)
			add((String) s.readObject());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		for (Entry it = head; it != null; it = it.next)
			sb.append(it.data);
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringList sl = new StringList();
		for (int i = 0; i < 5; i++) {
			sl.add(String.valueOf(i));
		}
		System.out.println(sl);
		try {
			FileOutputStream fos = new FileOutputStream("t.tmp");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(sl);
			oos.close();
			FileInputStream fis = new FileInputStream("t.tmp");
			ObjectInputStream ois = new ObjectInputStream(fis);
			StringList sl2 = (StringList) ois.readObject();
			System.out.println("Desialized obj = " + sl2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Remainder omitted
}
