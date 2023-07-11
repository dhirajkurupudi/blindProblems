package com.example.blind75.problems;

import java.util.HashMap;
import java.util.Map;

/*Given an integer return the fibonacci value for that index*/
public class Fibonacci {
	
	private static Map<Integer, Integer> map = new HashMap<>();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibMemonized(5));
	}

	private static int fib(int i) {
		if(i <=1) {
			return i;
		}
		
		return fib(i -1) + fib(i -2);
	}
	
	private static int fibMemonized(int i) {
		
		if(map.containsKey(i)) {
			return map.get(i);
		}
		if(i <= 1) {
			map.put(i, i);
			return i;
		}
		
		map.put(i, fibMemonized(i -1) + fibMemonized(i -2));
		return map.get(i);
	}

}
