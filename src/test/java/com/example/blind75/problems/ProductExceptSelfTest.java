package com.example.blind75.problems;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ProductExceptSelfTest {

	@ParameterizedTest
	@MethodSource("numbersProvider")
	void testSolve(int[] input, int[] result) {
		ProductExceptSelf exceptSelf = new ProductExceptSelf();
		assertArrayEquals(result, exceptSelf.solve(input));
	}

	static Stream<Object[]> numbersProvider() {
		return Stream.of(new Object[] { new int[] { 2, 1, 5, 3 }, new int[] { 15, 30, 6, 10 } },
				new Object[] { new int[] { 2, 1, 5, 0 }, new int[] { 0, 0, 0, 10 } },
				new Object[] { new int[] { 2, 0, 5, 0 }, new int[] { 0, 0, 0, 0 } });
	}
}
