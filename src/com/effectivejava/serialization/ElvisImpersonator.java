/**
 * Demo for "77 For instance control, prefer enum types to readResolve".
 */
package com.effectivejava.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Kaibo
 * 
 */
public class ElvisImpersonator {

	// Byte stream could not have come from real Elvis instance!
	private static final byte[] serializedForm = new byte[] {(byte) 0xac,(byte) 0xed, 0x0,
			0x5, 0x7e, 0x72, 0x0, 0x25, 0x63, 0x6f, 0x6d, 0x2e, 0x65, 0x66,
			0x66, 0x65, 0x63, 0x74, 0x69, 0x76, 0x65, 0x6a, 0x61, 0x76, 0x61,
			0x2e, 0x73, 0x65, 0x72, 0x69, 0x61, 0x6c, 0x69, 0x7a, 0x61, 0x74,
			0x69, 0x6f, 0x6e, 0x2e, 0x45, 0x6c, 0x76, 0x69, 0x73, 0x0, 0x0,
			0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x12, 0x0, 0x0, 0x78, 0x72, 0x0, 0xe,
			0x6a, 0x61, 0x76, 0x61, 0x2e, 0x6c, 0x61, 0x6e, 0x67, 0x2e, 0x45,
			0x6e, 0x75, 0x6d, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x12,
			0x0, 0x0, 0x78, 0x70, 0x74, 0x0, 0x8, 0x49, 0x4e, 0x53, 0x54, 0x41,
			0x4e, 0x43, 0x45 };

	public static void main(String[] args) {
		// Initializes ElvisStealer.impersonator and returns
		// the real Elvis (which is Elvis.INSTANCE)
//		byte[] serializedObj = serialize(ElvisStealer.impersonator.INSTANCE);
//		for (byte b : serializedObj)
//			System.out.printf("0x%x,", b);
		Elvis elvis = (Elvis) deserialize(serializedForm);
		Elvis impersonator = ElvisStealer.impersonator;
		elvis.printFavorites();
		impersonator.printFavorites();
	}

	/**
	 * @param serializedform2
	 * @return
	 */
	private static Elvis deserialize(byte[] serializedform2) {
		try {
			InputStream is = new ByteArrayInputStream(serializedform2);
			ObjectInputStream ois = new ObjectInputStream(is);
			return (Elvis) ois.readObject();
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	// Writes the object to the byte Array.
	private static byte[] serialize(Object obj) {
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ObjectOutputStream ois = new ObjectOutputStream(os);
			ois.writeObject(obj);
			return os.toByteArray();
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
}
