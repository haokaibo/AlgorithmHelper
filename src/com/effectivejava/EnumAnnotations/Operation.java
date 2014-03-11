/**
 * Demo for enum type use abstract methods for Compile time checking on added enum type. 
 */
package com.effectivejava.EnumAnnotations;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kaibo
 * 
 */
public enum Operation {
	PLUS("+") {
		public double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		public double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES("*") {
		public double apply(double x, double y) {
			return x * y;
		}
	},
	DIVIDE("/") {
		public double apply(double x, double y) {
			return x / y;
		}
	};
	private final String symbol;

	Operation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	public abstract double apply(double x, double y);

	// Implementing a fromString method on an enum type
	private static final Map<String, Operation> stringToEnum = new HashMap<String, Operation>();
	static { // Initialize map from constant name to enum constant
		for (Operation op : values())
			stringToEnum.put(op.toString(), op);
	}

	// Returns Operation for string, or null if string is invalid
	public static Operation fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}