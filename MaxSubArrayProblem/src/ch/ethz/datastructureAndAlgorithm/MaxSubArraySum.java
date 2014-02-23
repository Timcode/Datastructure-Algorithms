package ch.ethz.datastructureAndAlgorithm;

import ch.ethz.datastructureAndAlgorithm.implmentation.FindMaxSubArray;
import ch.ethz.datastructureAndAlgorithm.implmentation.MaxSubArrayFast;
import ch.ethz.datastructureAndAlgorithm.implmentation.MaxSubArrayFastest;
import ch.ethz.datastructureAndAlgorithm.implmentation.MaxSubArraySlow;


public class MaxSubArraySum {

	public static void main(String[] args) {
		int[] array = {2, -3, 6, 4, 5, -6};

		// O(n^3)
		FindMaxSubArray s = new MaxSubArraySlow();
		s.findMaxSubSumInSequence(array);
		System.out.println("Index: (" + s.getIndices()[0] + ", " + s.getIndices()[1] + ") Summe: " + s.getMaxSum());

		// O(n log n)
		FindMaxSubArray fast = new MaxSubArrayFast();
		fast.findMaxSubSumInSequence(array);
		System.out.println("Summe: " + fast.getMaxSum());

		// O(n)
		FindMaxSubArray fastest = new MaxSubArrayFastest();
		fastest.findMaxSubSumInSequence(array);
		System.out.println("Index: (" + s.getIndices()[0] + ", " + s.getIndices()[1] + ") Summe: " + s.getMaxSum());

	}
}
