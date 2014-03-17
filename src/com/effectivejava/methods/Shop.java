/**
 * Demo for "43 Return empty arrays or collections, not nulls".
 */
package com.effectivejava.methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Kaibo
 * 
 */
public class Shop {

	// The right way to return an array from a collection
	private final List<Cheese> cheesesInStock = new ArrayList<Cheese>();
	private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

	/**
	 * @return an array containing all of the cheeses in the shop.
	 */
	public Cheese[] getCheeses() {
		return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
	}

	/**
	 * The right way to return a copy of a collection
	 * 
	 * @return a list containing all of the cheeses in the shop.
	 */
	public List<Cheese> getCheeseList() {
		if (cheesesInStock.isEmpty())
			return Collections.emptyList(); // Always returns same list
		else
			return new ArrayList<Cheese>(cheesesInStock);
	}

	public static void main(String[] args) {
		Shop shop = new Shop();
		if (Arrays.asList(shop.getCheeses()).contains(Cheese.STILTON))
			System.out.println("Jolly good, just the thing.");
	}
}
