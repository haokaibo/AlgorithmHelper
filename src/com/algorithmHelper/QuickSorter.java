/**
 * 
 */
package com.algorithmHelper;

/**
 * @author Kaibo
 * 
 */
public class QuickSorter extends Sorter {
	private int[] m_targets;

	public QuickSorter(int[] targets) {
		m_targets = targets;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.algorithmHelper.Sorter#Sort(java.lang.Object[])
	 */
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		if (null == m_targets || m_targets.length <= 1)
			return;

		sortPart(0, m_targets.length - 1);
	} 

	private void sortPart(int head, int tail) {
		if (head < tail) {
			int current = tail;
			int i = head, j = tail;

			while (i < j) {
				while (i < current) {
					if (m_targets[i] > m_targets[current]) {
						Swap(m_targets, i, current);
						current = i;
						i++;
						break;
					}
					i++;
				}
				while (j > current) {
					if (m_targets[j] < m_targets[current]) {
						Swap(m_targets, j, current);
						current = j;
						j--;
						break;
					}
					j--;
				}
			}

			sortPart(head, current - 1);
			sortPart(current + 1, tail);
		}
	}

	private void Swap(int[] targets, int originIndex, int targetIndex) {
		int temp = targets[originIndex];
		targets[originIndex] = targets[targetIndex];
		targets[targetIndex] = temp;
	}

}
