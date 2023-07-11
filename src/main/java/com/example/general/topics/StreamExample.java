package com.example.general.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

	static boolean divisibleBy2(int num) {
		return num % 2 == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		/*
		 * List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		 * //predicate tests the condition List<Integer> evenNumbers =
		 * numbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
		 * //method reference implementation evenNumbers =
		 * numbers.stream().filter(StreamExample::divisibleBy2).collect(Collectors.
		 * toList()); System.out.println(evenNumbers);
		 * 
		 * List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Alex",
		 * "Andrew"); //Function applies i.e transforms the data List<Integer>
		 * nameLengths = names.stream().peek(System.out::println).map(String::length)
		 * .peek(System.out::println).collect(Collectors.toList());
		 * 
		 * System.out.println(nameLengths);
		 * 
		 * List<String> sortedNames =
		 * names.stream().sorted().collect(Collectors.toList());
		 * 
		 * System.out.println(sortedNames);
		 * 
		 * int sum = numbers.stream().reduce(0, Integer::sum);
		 * 
		 * sum = numbers.stream().reduce(0, (a, b) -> a + b);
		 * 
		 * System.out.println(sum);
		 * 
		 * Map<Character, List<String>> groupedNames = names.stream()
		 * .collect(Collectors.groupingBy(name -> name.charAt(0)));
		 * 
		 * System.out.println(groupedNames);
		 * 
		 * sum = numbers.parallelStream().reduce(0, Integer::sum);
		 * 
		 * System.out.println(sum);
		 * 
		 * String str = "Hello, World!"; Set<Character> duplicateCharacters =
		 * str.chars().mapToObj(c -> (char) c)
		 * .collect(Collectors.groupingBy(Function.identity(),
		 * Collectors.counting())).entrySet().stream() .filter(entry -> entry.getValue()
		 * > 1).map(Map.Entry::getKey).collect(Collectors.toSet());
		 * 
		 * System.out.println(duplicateCharacters); // Output: [o, l]
		 * 
		 * int sumOfEvenNumbers = numbers.stream().filter(num -> num % 2 ==
		 * 0).mapToInt(Integer::intValue).sum();
		 * 
		 * System.out.println(sumOfEvenNumbers);
		 */
		// ================================ partition by
		// ==========================================================
		Map<Boolean, List<Integer>> evenOddMap = numbers.stream()
				.collect(Collectors.partitioningBy(num -> num % 2 == 0));

		List<Integer> evenNumbers = evenOddMap.get(true);
		List<Integer> oddNumbers = evenOddMap.get(false);

		System.out.println("Even Numbers: " + evenNumbers); // Output: Even Numbers: [2, 4, 6, 8, 10]
		System.out.println("Odd Numbers: " + oddNumbers); // Output: Odd Numbers: [1, 3, 5, 7, 9]

		// ================================ flatmap
		// =============================================================

		/*
		 * Using flatMap(), we transform each inner list into a stream of its elements
		 * by calling List::stream. The flatMap() operation then combines all those
		 * streams into a single stream of integers.
		 */
		List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6),
				Arrays.asList(7, 8, 9));//[[][][]]

		List<Integer> flattenedList = nestedList.stream().flatMap(List::stream).collect(Collectors.toList());

		System.out.println(flattenedList);

		// Example 2 to expand a collection
		numbers = Arrays.asList(1, 2, 3, 4, 5);

		List<Integer> expandedList = numbers.stream().flatMap(num -> Arrays.asList(num, num * 2).stream())
				.collect(Collectors.toList());
		System.out.println(expandedList);

		/*
		 * optional values are handled by unwrapping them using flatMap()
		 */
		List<Optional<String>> strings = Arrays.asList(Optional.of("Hello"), Optional.empty(), Optional.of("World"),
				Optional.empty(), Optional.of("Java"));
														//filter(remove optionalempty)
		List<String> nonEmptyStrings = strings.stream().flatMap(Optional::stream).collect(Collectors.toList());

		System.out.println(nonEmptyStrings);

		// sorting using comparators
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("A", 25));
		persons.add(new Person("B", 30));
		persons.add(new Person("C", 20));

		// Sort based on age in ascending order
		List<Person> sortedByAge = persons.stream().sorted(Comparator.comparing(Person::getAge)).limit(10)
				 //.toList(); > Java 16 versions
				.collect(Collectors.toList());
		System.out.println("Sorted by Age (Ascending):");
		System.out.println(sortedByAge);
		
		Comparator<Person> byAge = 
				(Person o1, Person o2) -> Integer.valueOf(o1.getAge()).compareTo(Integer.valueOf(o2.getAge()));
		
		
		sortedByAge = persons.stream().sorted(byAge)
				 //.toList(); > Java 16 versions
				.collect(Collectors.toList());

		// Sort based on name in descending order
		List<Person> sortedByName = persons.stream()
				.sorted(Comparator.comparing(Person::getName, Comparator.reverseOrder())).toList();
		System.out.println("Sorted by Name (Descending):");
		System.out.println(sortedByName);

		// utility methods

		numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 1, 3, 6);

		List<Integer> distinctNumbers = numbers.stream().distinct().toList();

		System.out.println(distinctNumbers);

		IntStream.rangeClosed(1, 10).limit(5).forEach(System.out::println);

		IntStream.rangeClosed(1, 10).skip(5).forEach(System.out::println);

		numbers = Arrays.asList(1, 2, 3, 4, 5);

		boolean anyMatch = numbers.stream().anyMatch(num -> num % 2 == 0);

		System.out.println(anyMatch);

		numbers = Arrays.asList(2, 4, 6, 8, 10);

		boolean allMatch = numbers.stream().allMatch(num -> num % 2 == 0);

		System.out.println(allMatch);

		numbers = Arrays.asList(1, 3, 5, 7, 9);

		boolean noneMatch = numbers.stream().noneMatch(num -> num % 2 == 0);

		System.out.println(noneMatch);

		Stream<String> stream = Stream.of("Apple", "Banana", "Carrot", "Durian");

		String firstElement = stream.findFirst().orElse("None");

		System.out.println(firstElement);
		
		Stream<String> stream1 = Stream.of("Apple", "Banana", "Carrot", "Durian");

		String anyElement = stream1.findAny().orElse("None");

		System.out.println(anyElement);

		numbers = Arrays.asList(5, 3, 9, 1, 7);

		int minNumber = numbers.stream().min(Integer::compare).orElseThrow();

		System.out.println(minNumber);

		numbers = Arrays.asList(5, 3, 9, 1, 7);

		int maxNumber = numbers.stream().max(Integer::compare).orElseThrow();
		
		//numbers.stream().

		System.out.println(maxNumber);
		//splititerator
		//websocket
		//grpc
		//leetcode
		//json parser without class
	}

}
