package ch.ethz.datastructureAndAlgorithm.implmentation;

/*
 * Runs in O(n^3)
 * The lazy version
 */
public class MaxSubArraySlow implements FindMaxSubArray {

	private int MaxSumInSequence = 0;
	private int[] rangeOfMaxSum = new int[2];
	
	public MaxSubArraySlow(){	
	}
	
	@Override
	public void findMaxSubSequence(int[] sequence) {
		for(int i = 0; i<sequence.length; i++){
			for(int j = i; j <sequence.length; j++){
				int sum = 0;
				//Sum up within the range
				for(int k = i; k <= j; k++){
					sum += sequence[k];
				}
				if(sum>MaxSumInSequence){
					MaxSumInSequence = sum;
					rangeOfMaxSum[0]=i;
					rangeOfMaxSum[1]=j;
				}
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
