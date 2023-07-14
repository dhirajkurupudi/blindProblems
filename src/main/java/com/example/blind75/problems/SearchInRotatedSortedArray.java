package com.example.blind75.problems;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// [7 8 9 1 2 3]
	}
//search an element in rotated sorted array
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			if (nums[left] <= nums[mid]) {
				if (target < nums[left] || target > nums[mid]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				if (target > nums[right] || target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}

		return -1;
	}

}
