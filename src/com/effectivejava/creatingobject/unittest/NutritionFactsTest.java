/**
 * 
 */
package com.effectivejava.creatingobject.unittest;

import org.junit.Test;

import com.effectivejava.creatingobject.NutritionFacts;
import com.effectivejava.creatingobject.NutritionFacts.Builder;

/**
 * @author Kaibo
 * 
 */
public class NutritionFactsTest {

	@Test
	public void test() {
		Builder builder = new Builder(10, 100).calories(3).carbohydrate(2)
				.fat(1).sodium(4);
		NutritionFacts nutritionFacts = builder.build();
		System.out.println(nutritionFacts.toString());
	}

}
