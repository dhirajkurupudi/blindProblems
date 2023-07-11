package com.example.blind75.problems;

import java.util.HashSet;
import java.util.Set;

//Given array of integers return true if an element appears atleast twice in the array
public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 1, 5, 3};
		System.out.println(solve(arr));
	}

	private static boolean solve(int[] arr) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < arr.length; i++) {
			if(!set.add(arr[i])) {
				return true;
			}
		}
		return false;
	}

}
