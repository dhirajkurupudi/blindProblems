package com.example.blind75.problems;

import java.util.Arrays;

public class CoinsChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int coinChange(int[] coins, int amount) {
		int amt[] = new int[amount + 1];
		Arrays.fill(amt, amount + 1);
		amt[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j]) {
					amt[i] = Math.min(amt[i], 1 + amt[i - coins[j]]);
				}
			}
		}
		if (amt[amount] < amount + 1) {
			return amt[amount];
		}
		return -1;
	}
}
