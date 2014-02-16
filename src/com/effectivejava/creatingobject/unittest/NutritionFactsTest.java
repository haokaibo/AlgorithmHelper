/**
 * 
 */
package com.effectivejava.creatingobject.unittest;

import org.junit.Test;

import com.effectivejava.creatingobject.NutritionFacts;

/**
 * @author Kaibo
 * 
 */
public class NutritionFactsTest {

	@Test
	public void test() {
		NutritionFacts nutritionFacts = new NutritionFacts.Builder(10, 100)
				.calories(3).carbohydrate(2).fat(1).sodium(4).build();
		System.out.println(nutritionFacts.toString());
	}

}
