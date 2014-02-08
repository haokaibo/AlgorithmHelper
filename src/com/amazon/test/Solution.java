/**
 * 
 */
package com.amazon.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kaibo
 * 
 */
public class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		for (int i = 0; i < N; i++) {
			System.out.println("hello world");
		}
	}

	public static int MMChess(int[] grids, int[] cards) {
		int bestScore = 0;
		List<Integer> cardList = new ArrayList<Integer>();
		for (int i = 0, count = cards.length; i < count; i++) {
			cardList.add(cards[i]);
		}
		bestScore = computeNextStep(1, grids, cardList);
		return bestScore;
	}

	/**
	 * @param i
	 * @param grids
	 * @param cardList
	 * @return
	 */
	private static int computeNextStep(int index, int[] grids,
			List<Integer> cardList) {
		int step = 0;
		int bestScore = 0;
		int nextBestScore = 0;
		int maxScore = 0;
		int nextIndex = 0;
		if (grids == null)
			return bestScore;
		bestScore = grids[index - 1];
		// Just return the current step value if there is no further card
		if (cardList == null || cardList.size() == 0)
			return bestScore;
		for (int i = cardList.size() - 1; i >= 0; i--) {

			List<Integer> leftCards = new ArrayList<Integer>(cardList);
			step = leftCards.remove(i);
			nextIndex = index + step;
			nextBestScore = computeNextStep(nextIndex, grids, leftCards);
			if (nextBestScore > maxScore)
				maxScore = nextBestScore;
		}
		bestScore += maxScore;
		return bestScore;
	}
}
