/**
 * 
 */
package com.algorithmHelper;

/**
 * @author Kaibo
 * 
 */
public class BitOperator {
	public static int clearBitsIthgrough0(int num, int i) {
		int mask = ~((1 << (i + 1)) - 1);
		return num & mask;
	}

	public static int updateBit(int num, int i, int v) {
		int mask = ~(1 << i);
		return num & mask | (v << i);
	}
}
