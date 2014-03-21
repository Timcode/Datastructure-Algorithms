package implmentation;


public interface FindMaxSubArray {
	
	/*
	 * Find the best sequence in the array
	 */
	public void findMaxSubSequence(int[] sequence);
	
	/*
	 * Return the sum found in the sequence
	 */
	public int getMaxSum();
	
	/*
	 * Return the indices if possible
	 */
	public int[] getIndices();
}
