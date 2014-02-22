package ch.eth.datastructureAndAlgorithm;

import ch.eth.datastructureAndAlgorithm.implmentation.FindMaxSubArray;
import ch.eth.datastructureAndAlgorithm.implmentation.MaxSubArrayFast;
import ch.eth.datastructureAndAlgorithm.implmentation.MaxSubArrayFastest;
import ch.eth.datastructureAndAlgorithm.implmentation.MaxSubArraySlow;


public class MaxSubArraySum {

	public static void main(String[] args) {
		int[] array = {2, 3, -6, 7};

		// O(n^3)
		FindMaxSubArray s = new MaxSubArraySlow();
		s.findMaxSubSequence(array);
		System.out.println("Index: (" + s.getIndices()[0] + ", " + s.getIndices()[1] + ") Summe: " + s.getMaxSum());

		// O(n log n)
		FindMaxSubArray fast = new MaxSubArrayFast();
		fast.findMaxSubSequence(array);
		System.out.println("Summe: " + fast.getMaxSum());

		// O(n)
		FindMaxSubArray fastest = new MaxSubArrayFastest();
		fastest.findMaxSubSequence(array);
		System.out.println("Index: (" + s.getIndices()[0] + ", " + s.getIndices()[1] + ") Summe: " + s.getMaxSum());

	}
}
