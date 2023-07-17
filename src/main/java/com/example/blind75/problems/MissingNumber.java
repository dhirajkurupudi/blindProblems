package com.example.blind75.problems;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int missingNumber(int[] nums) {
		int xOr = 0;

		for (int i = 0; i <= nums.length; i++) {
			xOr = xOr ^ i;
		}

		for (int i = 0; i < nums.length; i++) {
			xOr = xOr ^ nums[i];
		}

		return xOr;
	}

}
