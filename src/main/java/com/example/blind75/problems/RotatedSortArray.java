package com.example.blind75.problems;

public class RotatedSortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//lets say we have an array  
		//we rotated it 3 times 4 6 9 1 3
		
		//now we are given a rotated array we have to determine if the original array was sorted or not
		//[4, 6, 9, 1, 3] is sorted
		//[4, 6, 9, 1, 9] is not sorted 
		//[4, 3, 9, 1, 3] is sorted
		//[3, 6, 0, 1, 3] is sorted
		
		int[] input = {3, 6, 0, 1, 3};
		System.out.println(isRotatedSortedArray(input));

	}
	
	public static String isRotatedSortedArray(int[] input) {
		int counter = 0;
		
		for(int i = 1; i < input.length; i++) {
			if(input[i - 1] > input[i]) {
				counter++;
			}
		}
		
		if(input[0] < input[input.length - 1]) {
			counter++;
		}
		if(counter > 1) {
			return "not sorted";
		}else {
			return "sorted";
		}
	}

}
