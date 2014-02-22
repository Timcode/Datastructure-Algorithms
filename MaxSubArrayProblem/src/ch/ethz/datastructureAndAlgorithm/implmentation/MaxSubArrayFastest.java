package ch.ethz.datastructureAndAlgorithm.implmentation;

/*
 * Runs in O(n)
 */
public class MaxSubArrayFastest implements FindMaxSubArray {

	private int MaxSumInSequence = 0;
	private int[] rangeOfMaxSum = new int[2];
	
	public MaxSubArrayFastest(){	
	}
	
	@Override
	public void findMaxSubSequence(int[] sequence) {
		int i = 0;
		int sum = 0;
		for(int j = 0; j < sequence.length; j++){
			sum += sequence[j];
			
			//Quick and dirty to save the info, could be done better
			if(sum > MaxSumInSequence){
				MaxSumInSequence = sum;
				rangeOfMaxSum[0] = i;
				rangeOfMaxSum[1] = j;
			} 
			
			if(sum < 0 ){
				sum = 0;
				i = j + 1;
			}		
		}
	}

	@Override
	public int getMaxSum() {
		return MaxSumInSequence;
	}

	@Override
	public int[] getIndices() {
		return rangeOfMaxSum;
	}
	
}
