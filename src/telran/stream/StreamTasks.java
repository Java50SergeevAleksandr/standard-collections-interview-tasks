package telran.stream;

import java.util.*;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTasks {
	private static final int N_NUMBERS = 10_000;
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = Integer.MAX_VALUE;

	public static void printDigitStatistics() {
		long start = System.currentTimeMillis();

		new Random().ints(N_NUMBERS, MIN_VALUE, MAX_VALUE).parallel().mapToObj(Integer::toString)
				.flatMapToInt(String::chars).boxed().collect(Collectors.groupingBy(n -> n, Collectors.counting()))
				.entrySet().stream().sorted((e1, e2) -> {
					return Long.compare(e2.getValue(), e1.getValue());
				}).forEach(e -> System.out.printf("%c -> %d\n", e.getKey(), e.getValue()));

		System.out.println(System.currentTimeMillis() - start);
	}

	/*===================== Additional Solutions ===================== */
	
	public static void displayDigitStatisticsFastest() {
		long start = System.currentTimeMillis();

		long[] digCounters = new Random().ints(N_NUMBERS, MIN_VALUE, MAX_VALUE)
				.flatMap(x -> Integer.toString(x).chars()).parallel()
				.collect(() -> new long[10], (arr, i) -> arr[i - '0']++, (arr1, arr2) -> {
					for (int i = 0; i < 10; i++) {
						arr1[i] += arr2[i];
					}
				});

		Map<Integer, Long> map = new HashMap<>(10);
		for (int i = 0; i < 10; i++) {
			map.put(i, digCounters[i]);
		}
		map.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
				.forEach(x -> System.out.printf("%d -> %d\n", x.getKey(), x.getValue()));

		System.out.println(System.currentTimeMillis() - start);
	}

	// By Maria Disin - sequential array instead of parallel stream
	public static void displayDigitStatisticsSuperFastest() {
		long start = System.currentTimeMillis();

		long[] digitCounts = new long[10];
		new Random().ints(N_NUMBERS, MIN_VALUE, MAX_VALUE)
				// .parallel() // ERROR!
				.forEach(num -> {
					while (num > 0) {
						int digit = num % 10;
						++digitCounts[digit];
						num /= 10;
					}
				});

		Map<Integer, Long> map = new HashMap<>(10);
		for (int i = 0; i < 10; i++) {
			map.put(i, digitCounts[i]);
		}
		map.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
				.forEach(x -> System.out.printf("%d -> %d\n", x.getKey(), x.getValue()));

		System.out.println(System.currentTimeMillis() - start);
	}

	public static void combinedSolution() {
		long start = System.currentTimeMillis();
		Map<Integer, Long> map = new Random().ints(N_NUMBERS, MIN_VALUE, MAX_VALUE).collect(() -> new HashMap<>(10),
				(sup, n) -> {
					while (n > 0) {
						int digit = n % 10;						
						sup.merge(digit, 1L, Long::sum);
						n /= 10;
					}
				}, (s1, s2) -> {
				});

		map.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
				.forEach(x -> System.out.printf("%d -> %d\n", x.getKey(), x.getValue()));

		System.out.println(System.currentTimeMillis() - start);
	}
}