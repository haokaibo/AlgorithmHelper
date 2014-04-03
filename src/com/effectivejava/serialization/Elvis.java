/**
 * 
 */
package com.effectivejava.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Kaibo Hao
 *
 */
public class Elvis implements Serializable {

	/**
	 * The version UID for the serial version object.
	 */
	private static final long serialVersionUID = 4285474589312744336L;
	public static final Elvis INSTANCE = new Elvis();
	private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

	public void printFavorites() {
		System.out.println(Arrays.toString(favoriteSongs));
	}

	private Elvis() {
	}

	// readResolve for instance control - you can do better!
	private Object readResolve() {
		// Return the one true Elvis and let the garbage collector
		// take care of the Elvis impersonator.
		return INSTANCE;
	}

	public static void main(String[] args) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(os);
			oos.writeObject(Elvis.INSTANCE);
			oos.close();

			ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(is);
			Elvis e = (Elvis) ois.readObject();
			System.out.printf("Elvis is %s the one used before? ",
					e == Elvis.INSTANCE ? "" : "not");
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
