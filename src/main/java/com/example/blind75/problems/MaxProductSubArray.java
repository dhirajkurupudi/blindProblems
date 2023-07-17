package com.example.blind75.problems;

public class MaxProductSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x[] = { 1, -3, 4, 2 };
		System.out.println(solve(x));
	}

	/* Given an array find the max product subarray */

	public static int solve(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int min = nums[0];
		int max = nums[0];
		int result = max;

		for (int i = 1; i < nums.length; i++) {
			int cur = nums[i];
			int temp = Math.max(cur, Math.max(max * cur, min * cur));
			min = Math.min(cur, Math.min(min * cur, max * cur));
			max = temp;

			result = Math.max(result, max);
		}

		return result;
	}
}
