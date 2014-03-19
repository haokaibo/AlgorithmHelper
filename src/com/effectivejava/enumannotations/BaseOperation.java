/**
 * Demo for the "34 Emulate extensible enums with interfaces".
 */
package com.effectivejava.enumannotations;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kaibo
 * 
 */
public enum BaseOperation implements Operation {
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

	BaseOperation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	public abstract double apply(double x, double y);

	// Implementing a fromString method on an enum type
	private static final Map<String, BaseOperation> stringToEnum = new HashMap<String, BaseOperation>();
	static { // Initialize map from constant name to enum constant
		for (BaseOperation op : values())
			stringToEnum.put(op.toString(), op);
	}

	// Returns BaseOperation for string, or null if string is invalid
	public static BaseOperation fromString(String symbol) {
		return stringToEnum.get(symbol);
	}

	
}