/**
 * 
 */
package com.effectivejava.creatingobject;

/**
 * @author Kaibo
 * 
 */
// Builder Pattern
public class NutritionFacts {
	@SuppressWarnings("unused")
	private final int servingSize;
	@SuppressWarnings("unused")
	private final int servings;
	@SuppressWarnings("unused")
	private final int calories;
	@SuppressWarnings("unused")
	private final int fat;
	@SuppressWarnings("unused")
	private final int sodium;
	@SuppressWarnings("unused")
	private final int carbohydrate;

	public static class Builder {
		// Required parameters
		private final int servingSize;
		private final int servings;
		// Optional parameters - initialized to default values
		private int calories = 0;
		private int fat = 0;
		private int carbohydrate = 0;
		private int sodium = 0;

		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder calories(int val) {
			calories = val;
			return this;
		}

		public Builder fat(int val) {
			fat = val;
			return this;
		}

		public Builder carbohydrate(int val) {
			carbohydrate = val;
			return this;
		}

		public Builder sodium(int val) {
			sodium = val;
			return this;
		}

		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}

	private NutritionFacts(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String
				.format("NutritionFacts[servingSize:%d, servings:%d, calories: %d, fat: %d, sodium: %d, carbohydrate: %d]",
						this.servingSize, this.servings, this.calories,
						this.fat, this.sodium, this.carbohydrate);
	}

}
