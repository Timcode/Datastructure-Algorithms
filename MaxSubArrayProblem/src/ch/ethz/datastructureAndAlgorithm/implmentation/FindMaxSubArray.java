package ch.ethz.datastructureAndAlgorithm.implmentation;


public interface FindMaxSubArray {
	
	/*
	 * Find the best sequence in the array
	 */
	public void findMaxSubSumInSequence(int[] sequence);
	
	/*
	 * Return the maximal sum found in the sequence
	 */
	public int getMaxSum();
	
	/*
	 * Return the indices, if possible
	 */
	public int[] getIndices();
}
