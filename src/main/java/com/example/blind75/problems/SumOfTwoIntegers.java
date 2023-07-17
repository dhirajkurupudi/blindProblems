package com.example.blind75.problems;

public class SumOfTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int getSum(int a, int b) {
		while (b != 0) {
			int temp = a ^ b;
			int carry = (a & b) << 1;
			a = temp;
			b = carry;
		}
		return a;
	}

}
