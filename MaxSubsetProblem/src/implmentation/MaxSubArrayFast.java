package implmentation;

/*
 *  O(n log n)
 */
public class MaxSubArrayFast implements FindMaxSubArray {

	private int MaxSumInSequence = 0;

	public MaxSubArrayFast() {
	}

	@Override
	public void findMaxSubSequence(int[] sequence) {
		MaxSumInSequence = maxSumDivideAndConquer(sequence, 0, sequence.length - 1);
	}

	/**
	 * Solves the problem with divide and Conquer
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	private int maxSumDivideAndConquer(int[] a, int left, int right) {

		// Recursion ends
		if (left == right)
			if (a[left] > 0)
				return a[left];
			else
				return 0;

		int center = (left + right) / 2;
		int maxLeftSum = maxSumDivideAndConquer(a, left, center);
		int maxRightSum = maxSumDivideAndConquer(a, center + 1, right);

		int maxLeftBorderSum = 0, leftBorderSum = 0;
		for (int i = center; i >= left; i--) {
			leftBorderSum += a[i];
			if (leftBorderSum > maxLeftBorderSum)
				maxLeftBorderSum = leftBorderSum;
		}

		int maxRightBorderSum = 0, rightBorderSum = 0;
		for (int i = center + 1; i <= right; i++) {
			rightBorderSum += a[i];
			if (rightBorderSum > maxRightBorderSum)
				maxRightBorderSum = rightBorderSum;
		}

		return findMaxOfThreeValues(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
	}

	/**
	 * Return maximum of three integers.
	 */
	private static int findMaxOfThreeValues(int a, int b, int c) {
		return a > b ? a > c ? a : c : b > c ? b : c;
	}

	@Override
	public int getMaxSum() {
		return MaxSumInSequence;
	}

	@Override
	public int[] getIndices() {
		return null;
	}

}
