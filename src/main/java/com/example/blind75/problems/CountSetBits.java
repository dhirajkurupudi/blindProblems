package com.example.blind75.problems;

public class CountSetBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int count(int n) {
		int count = 0;

		while (n != 0) {
			count++;
			n = n & (n - 1);
		}

		return count;
	}

}
