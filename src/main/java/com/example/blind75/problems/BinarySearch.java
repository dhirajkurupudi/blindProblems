package com.example.blind75.problems;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Given this is a sorted array may contain duplicates
		int[] a = { 1, 3, 4, 5, 6, 8, 11, 20, 40, 55, 77, 89, 101 };
		System.out.println(findElement(a, 12));

	}

	private static boolean findElement(int[] a, int element) {
		int left = 0;
		int right = a.length - 1;

		while (left < right) {
			System.out.println("Left :" + left + " Right :" + right);
			int mid = left + (right - left) / 2; // to avoid overflow
			if (element < a[mid]) {
				right = mid - 1;
			} else if (element > a[mid]) {
				left = mid + 1;
			} else {
				return true;
			}
		}
		return false;
	}

}
