package com.example.blind75.problems;

import java.util.Arrays;

public class ProductExceptSelf {
	
	public int[] solve(int[] numbers) {
		// TODO Auto-generated method stub
		int[] result = new int[numbers.length];
		Arrays.fill(result, 1);
		
		int prefix = 1;
		//forward product
		for(int i = 0 ; i < numbers.length; i++) {
			result[i] = prefix;
			prefix = prefix * numbers[i];
		}
		//reverse product
		int postfix = 1;
		for(int i = numbers.length - 1; i >= 0; i--) {
			result[i] = result[i] * postfix;
			postfix = postfix * numbers[i];
		}
		
		return result;
	}

}
