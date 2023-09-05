package telran.stream;

import java.util.Random;
import java.util.stream.Collectors;

public class StreamTasks {
	private static final int N_NUMBERS = 1_000_000;
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = Integer.MAX_VALUE;

	public static void printDigitStatistics() {
		long start = System.currentTimeMillis();

		new Random().ints(N_NUMBERS, MIN_VALUE, MAX_VALUE).mapToObj(Integer::toString).flatMapToInt(String::chars)
				.boxed().collect(Collectors.groupingBy(n -> n, Collectors.counting())).entrySet().stream()
				.sorted((e1, e2) -> {
					return Long.compare(e2.getValue(), e1.getValue());
				}).forEach(e -> System.out.printf("%c -> %d\n", e.getKey(), e.getValue()));

		System.out.println(System.currentTimeMillis() - start);
	}	
}