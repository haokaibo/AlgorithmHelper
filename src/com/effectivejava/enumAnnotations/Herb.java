/**
 * Added demo for the "Use EnumMap instead of ordinal indexing".
 */
package com.effectivejava.enumAnnotations;

/**
 * @author Kaibo
 * 
 */
public class Herb {
	public enum Type {
		ANNUAL, PERENNIAL, BIENNIAL
	}

	private final String name;
	public final Type type;

	public Herb(String name, Type type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return name;
	}
}
