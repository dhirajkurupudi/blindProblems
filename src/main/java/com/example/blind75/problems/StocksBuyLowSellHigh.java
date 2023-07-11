package com.example.blind75.problems;

public class StocksBuyLowSellHigh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] prices = {7, 1, 5, 3, 6, 4};
		//buy low sell high
		solve(prices);
//N^2 2 pointer approach
	}
	
	private static void solve(int [] x) {
		int left = 0;
		int right = 1;
		int max = 0;
		
		while(right < x.length) {
			if(x[left] < x[right]) {
				max = Math.max(x[right] - x[left], max);
			}else {
				left = right;
			}
			right++;
		}
		
		System.out.println(max);
		
	}

}
