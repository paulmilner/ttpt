package com.jeannot.ttpt;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests for IntegerArrayTask
 *
 */
public class IntegerArrayTaskTest {
	
	private IntegerArrayTask task = new IntegerArrayTask();
	
	@Test
	public void check_expectation_of_array_not_null() {
		try {
			task.calculateLengthOfLongestAscendingOrderedSubsequence(null);
			fail("Expecting an assertion failure");
		}
		catch (NullPointerException npe) {
			//OK, expected this.
		}
	}
	
	@Test
	public void check_expectation_of_array_size_greater_than_zero() {
		try {
			task.calculateLengthOfLongestAscendingOrderedSubsequence(new int[]{});
			fail("Expecting an assertion failure");
		}
		catch (IllegalArgumentException iae) {
			//OK, expected this.
		}
	}
	
	@Test
	public void check_result_1() {
		int result = task.calculateLengthOfLongestAscendingOrderedSubsequence(new int[]{1, 4, 1, 4, 2, 1, 3, 5, 6, 2, 3, 7});
		assertEquals("Result not as expected",4,result);
	}
	
	@Test
	public void check_result_2() {
		int result = task.calculateLengthOfLongestAscendingOrderedSubsequence(new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5});
		assertEquals("Result not as expected",3,result);
	}
	
	@Test
	public void check_result_3() {
		int result = task.calculateLengthOfLongestAscendingOrderedSubsequence(new int[]{2, 7, 1, 8, 2, 8, 1});
		assertEquals("Result not as expected",2,result);
	}
	
}
