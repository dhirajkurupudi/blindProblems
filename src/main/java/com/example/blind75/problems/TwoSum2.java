package com.example.blind75.problems;

//Given a sorted array find indexes such that the sum of elements of those index sums upto be the target
public class TwoSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [ 2, 3, 4 , 5, 6, 8,10]
		// BS TC O(NlogN)
		//    SC O(1)
	}

	public int[] twoSum2(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			if (nums[left] + nums[right] > target) {
				right = right - 1;
			} else if (nums[left] + nums[right] < target) {
				left = left + 1;
			} else {
				return new int[] { left + 1, right - 1 };
			}
		}
		return null;
		//TC O(N)
		//SC O(1)
	}
	
	

}
