/**
 * Demo for "41 Use overloading judiciously".
 */
package com.effectivejava.methods;

import java.math.BigInteger;
import java.util.*;

/**
 * @author Kaibo
 * 
 */
public class CollectionClassifier {
	public static String classify(Set<?> s) {
		return "Set";
	}

	public static String classify(Collection<?> c) {
		return "Unknown Collection";
	}

	public static String classify(List<?> lst) {
		return "List";
	}

	public static void main(String[] args) {
		Collection<?>[] collections = { new HashSet<String>(),
				new ArrayList<BigInteger>(),
				new HashMap<String, String>().values() };
		for (Collection<?> c : collections)
			System.out.println(classify(c));

		// the result will prints three times "Unknown Collection"
	}
}
