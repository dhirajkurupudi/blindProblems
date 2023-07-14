package com.example.blind75.problems;

public class FindMinInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//returns minimum from array using binary search approach
	public static int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int ans = nums[0];
		
		if(nums.length == 1) {
			return nums[0];
		}
		
		while(left <= right) {
			if(nums[left] < nums[right]) {
				ans = Math.min(ans, nums[left]);
			}
			int mid = left + (right -left)/2;
			
			ans = Math.min(ans, nums[mid]);
			if(nums[left] <= nums[mid]) {
				
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return ans;
		
	}

}
