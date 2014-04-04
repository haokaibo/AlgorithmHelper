/**
 * Demo for "77 For instance control, prefer enum types to readResolve".
 */
package com.effectivejava.serialization;

//import java.io.ObjectStreamException;
//import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Kaibo
 * 
 */
// Enum singleton - the preferred approach
public enum Elvis {
	INSTANCE;
	private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

	public void printFavorites() {
		System.out.println(Arrays.toString(favoriteSongs));
	}
}
// // Broken singleton - has nontransient object reference field!
// public class Elvis implements Serializable {
// /**
// *
// */
// private static final long serialVersionUID = 1L;
// public static final Elvis INSTANCE = new Elvis();
//
// private Elvis() {
// }
//
// private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };
//
// public void printFavorites() {
// System.out.println(Arrays.toString(favoriteSongs));
// }
//
// private Object readResolve() throws ObjectStreamException {
// return INSTANCE;
// }
// }