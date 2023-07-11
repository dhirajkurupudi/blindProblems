package com.example.blind75.problems;

public class MaxSumSubArray {

	public static void main(String[] args) {
		
		int[] nums = {1, -1, 2, -6, 4, 2, -3};
		System.out.println(solve(nums));

	}
	/* problem statement: Return maxSum of a contiguous subArray
	 * 
	 * pseudo code : 
	 * 			curSum, maxSum = nums[0]
	 * 			for( i = 1 -> N -1)
	 * 				if (curSum < 0){
	 * 					curSum = 0;
	 * 				}
	 * 				curSum = curSum + nums[i];
	 * 				maxSum = max(curSum, maxSum);
	 * 			}
	 * 			return maxSum;
	 * 				 
	 * 
	 * code walk through: 
	 *  		[1, -1, 2, -6, 4, 2, -3] 
	 *  curSum   1   0  2  -4  4  6   3
	 *  maxSum   1   1  2   2  4  6   6
	 *  output   6
	 *  
	 * 
	 *  
	 *  TC O(N)
	 *  SC O(1)
	 */

	public static long solve(int[] nums) {
		long maxSum = nums[0];
		long curSum = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(curSum < 0) {
				curSum = 0;
			}
			curSum = curSum + nums[i];
			maxSum = Math.max(maxSum, curSum);
		}
		return maxSum;
	}

}
