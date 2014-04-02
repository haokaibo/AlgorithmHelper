/**
 * 
 */
package com.effectivejava.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Kaibo
 * 
 */
public class Foo extends AbstractFoo implements Serializable {
	private void readObject(ObjectInputStream s) throws IOException,
			ClassNotFoundException {
		s.defaultReadObject();
		// Manually deserialize and initialize superclass state
		int x = s.readInt();
		int y = s.readInt();
		initialize(x, y);
	}

	private void writeObject(ObjectOutputStream s) throws IOException {
		s.defaultWriteObject();
		// Manually serialize superclass state
		s.writeInt(getX());
		s.writeInt(getY());
	}

	// Constructor does not use the fancy mechanism
	public Foo(int x, int y) {
		super(x, y);
	}

	private static final long serialVersionUID = 1856835860954L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Foo foo = new Foo(1, 2);
		System.out.println(foo);
		FileOutputStream fos;
		String fileName = "t.tmp";
		try {
			fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(foo);
			oos.close();
			Foo foo2 = new Foo(3, 4);
			System.out.println(foo2);
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			foo2 = (Foo) (ois.readObject());
			ois.close();
			System.out.println(foo2);
			System.out.printf("foo==foo2: %b%n", foo == foo2);
			System.out.printf("foo.equals(foo2): %b%n", foo.equals(foo2));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
