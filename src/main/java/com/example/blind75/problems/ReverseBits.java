package com.example.blind75.problems;

public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int reverseBits(int n) {
		int reverse = 0;

		for (int i = 0; i < 32; i++) {
			reverse = reverse << 1;
			reverse = reverse | (n & 1);
			n = n >> 1;
		}
		return reverse;
	}

}
