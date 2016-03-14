package com.jeannot.ttpt;

import org.apache.commons.lang3.Validate;

/**
 * Given an unordered array of integers of length N > 0, calculate the length of
 * the longest ordered (ascending from left [lower index] to right [higher index])
 * sub-sequence within the array.
 * Example 1
 * Input: [1, 4, 1, 4, 2, 1, 3, 5, 6, 2, 3, 7]
 * Expected Output: 4
 * Example 2
 * Input: [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]
 * Expected Output: 3
 * Example 3
 * Input: [2, 7, 1, 8, 2, 8, 1]
 * Expected Output: 2
 * 
 *
 */
public class IntegerArrayTask {
	
	public int calculateLengthOfLongestAscendingOrderedSubsequence(int[] input) {
		Validate.notNull(input);
		Validate.isTrue(input.length>0);
		
		int result = 0;
		int longest = 1; //because there will always be at least 1 in the longest sequence...
		
		for (int i=1; i<input.length; i++) {
			int current = input[i];
			int previous = input[i-1];
			if (current >= previous) {
				longest++;
			} else {
				if (longest > result) result = longest;
				longest = 1; //reset longest
			}
		}
		return result;
	}
}
