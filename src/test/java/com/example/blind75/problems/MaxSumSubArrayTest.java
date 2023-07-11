package com.example.blind75.problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MaxSumSubArrayTest {

	@ParameterizedTest
	@MethodSource("numbersProvider")
	void testSolve(int[] input, int result) {
		assertEquals(result, MaxSumSubArray.solve(input));
	}

	static Stream<Object[]> numbersProvider() {
		return Stream.of(new Object[] { new int[] { 2, 1, 5, 3 }, 11 },
				new Object[] { new int[] { 0, 0, 0, 0 }, 0 },
				new Object[] { new int[] {-4, -1, -5, -2, -3 }, -1 });
	}

}
