/**
 * 
 */
package com.algorithmHelper;

import java.util.*;

/**
 * @author Kaibo
 * 
 */
public class KPicker {
	public List<Integer> PickK(List<Integer> arr, int k) {
		if (null == arr || k <= 0)
			return null;
		if (arr.size() <= k)
			return arr;
		List<Integer> frontArr = new ArrayList<>();
		List<Integer> backArr = new ArrayList<>();
		List<Integer> resultArr = new ArrayList<>();
		Partition(arr, frontArr, backArr);
		List<Integer> tempResult = PickK(frontArr, k);
		if (null != tempResult)
			resultArr.addAll(tempResult);
		tempResult = PickK(backArr, k - frontArr.size());
		if (null != tempResult)
			resultArr.addAll(tempResult);
		return resultArr;
	}

	/**
	 * @param arr
	 * @param frontArr
	 * @param backArr
	 */
	private void Partition(List<Integer> arr, List<Integer> frontArr,
			List<Integer> backArr) {
		// TODO Auto-generated method stub
		int randomPos = arr.get((int) (arr.size() * Math.random()));
		randomPos = randomPos >= arr.size() ? arr.size() - 1 : randomPos;
		int pIndex = randomPos;
		swap(arr, 0, pIndex);
		int p = arr.get(0);
		int currentValue = 0;
		for (int i = 1, count = arr.size(); i < count; i++) {
			currentValue = arr.get(i);
			if (p < currentValue)
				frontArr.add(currentValue);
			else
				backArr.add(currentValue);
		}
		if (frontArr.size() < backArr.size())
			frontArr.add(p);
		else
			backArr.add(p);
		System.out.printf("Step[%s]\n", arr.toString());
		System.out.printf("FrontArr: %s\t", frontArr.toString());
		System.out.printf("BackArr: %s\n", backArr.toString());
	}

	private void swap(List<Integer> arr, int originIndex, int targetIndex) {
		Integer temp = arr.get(originIndex);
		arr.set(originIndex, arr.get(targetIndex));
		arr.set(targetIndex, temp);
	}
}
