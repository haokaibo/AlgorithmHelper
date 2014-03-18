/**
 * The demo for "42 Use varargs judiciously".
 */
package com.effectivejava.methods;

import java.util.Arrays;

/**
 * @author Kaibo
 * 
 */
public class Varargs {
	public static void main(String[] args) {
		int[] digits = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 4 };
		System.out.println(Arrays.asList(digits));
		System.out.println(Arrays.toString(digits));
	}

	// Simple use of varargs
	static int sum(int... args) {
		int sum = 0;
		for (int arg : args)
			sum += arg;
		return sum;
	}

	static int min(int firstArg, int... remainingArgs) {
		int min = firstArg;
		for (int arg : remainingArgs)
			if (arg < min)
				min = arg;
		return min;
	}

	public void foo() {
	}

	public void foo(int a1) {
	}

	public void foo(int a1, int a2) {
	}

	public void foo(int a1, int a2, int a3) {
	}

	public void foo(int a1, int a2, int a3, int... rest) {
	}

}
