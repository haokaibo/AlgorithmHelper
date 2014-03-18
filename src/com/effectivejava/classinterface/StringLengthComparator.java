/**
 * 
 */
package com.effectivejava.classinterface;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Kaibo
 * 
 */
public class StringLengthComparator implements Comparator<String> {

	public static final StringLengthComparator INSTANCE = new StringLengthComparator();

	private StringLengthComparator() {

	}

	/*
	 * @see
	 * com.effectivejava.classinterface.Comparator#compare(java.lang.Object,
	 * java.lang.Object)
	 */
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		return s1.length() - s2.length();
	}

	public static void main(String[] args) {
		String[] a = new String[] { "I", "This", "a", "is" };
		System.out.println("a origin values:");
		printStringArray(a);
		System.out.println("b sorted values:");
		Arrays.sort(a, StringLengthComparator.INSTANCE);
		for (int i = 0, len = a.length; i < len; i++)
			System.out.println(a[i]);
		System.out.println();
		String[] b = new String[] { "He", "is", "a", "programmer" };
		System.out.println("b origin values:");
		printStringArray(b);
		System.out.println("b sorted values:");
		Arrays.sort(b, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		printStringArray(b);
	}

	private static void printStringArray(String[] strs) {
		for (int i = 0, len = strs.length; i < len; i++)
			System.out.println(strs[i]);
	}
}
