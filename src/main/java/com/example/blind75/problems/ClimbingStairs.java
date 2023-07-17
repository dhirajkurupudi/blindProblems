package com.example.blind75.problems;

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		int one = 1;
		int two = 2;

		for (int i = 3; i <= n; i++) {
			int steps = one + two;
			one = two;
			two = steps;
		}
		return two;
	}

}
