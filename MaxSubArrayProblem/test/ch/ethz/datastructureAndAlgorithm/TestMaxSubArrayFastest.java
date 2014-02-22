package ch.ethz.datastructureAndAlgorithm;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ch.ethz.datastructureAndAlgorithm.implmentation.FindMaxSubArray;
import ch.ethz.datastructureAndAlgorithm.implmentation.MaxSubArrayFastest;

public class TestMaxSubArrayFastest {

private FindMaxSubArray solver;
	
	@Before
	public void setUp(){
		solver = new MaxSubArrayFastest();
	}
	
	@Test
	public void testOne() {
		int[] sequence = {1,2,3,4,5,6,7,8,9};
		solver.findMaxSubSumInSequence(sequence);
		assertEquals(45, solver.getMaxSum());
	}
	
	@Test
	public void testTwo() {
		int[] sequence = {14};
		solver.findMaxSubSumInSequence(sequence);
		assertEquals(14, solver.getMaxSum());
	}
	
	@Test
	public void testThree() {
		int[] sequence = {4, -4, 4, -4};
		solver.findMaxSubSumInSequence(sequence);
		assertEquals(4, solver.getMaxSum());
	}
	
	@Test
	public void testFour() {
		int[] sequence = {30, -21, 3, 5, 6, 100, -50, 4};
		solver.findMaxSubSumInSequence(sequence);
		assertEquals(123, solver.getMaxSum());
	}

}
