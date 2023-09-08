package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.*;

import telran.interviews.Multicounters;

class MulticountersTest {

	Multicounters count;

	@BeforeEach
	void setUp() {
		count = new Multicounters();
	}

	@Test
	void addTest() {
		assertEquals(1, count.addCounter("first"));
		assertEquals(2, count.addCounter("first"));
		assertEquals(1, count.addCounter("sec"));
	}

	@Test
	void getCounterTest() {
		count.addCounter("first");
		assertEquals(1, count.getCounter("first"));
		count.addCounter("first");
		assertEquals(2, count.getCounter("first"));
		assertThrowsExactly(NoSuchElementException.class, () -> count.getCounter("sec"));
	}

	@Test
	void getItemsMaxCounterTest() {
		count.addCounter("first");
		String[] expected = { "first" };
		assertArrayEquals(expected, count.getItemsMaxCounter().toArray());

		count.addCounter("sec");
		String[] expected1 = { "sec", "first" };
		assertArrayEquals(expected1, count.getItemsMaxCounter().toArray());

		count.addCounter("sec");
		String[] expected2 = { "sec" };
		assertArrayEquals(expected2, count.getItemsMaxCounter().toArray());
	}

	@Test
	void removeItemTest() {
		count.addCounter("first");
		count.addCounter("sec");
		count.removeItem("sec");
		String[] expected = { "first" };
		assertArrayEquals(expected, count.getItemsMaxCounter().toArray());
		assertThrowsExactly(NoSuchElementException.class, () -> count.removeItem("sec"));
	}

	@Test
	void getItemsByCounterTest() {
		count.addCounter("first");
		count.addCounter("sec");
		count.addCounter("sec");

		String[] expected = { "first" };
		assertArrayEquals(expected, count.getItemsByCounter(1, 1).toArray());

		String[] expected1 = { "sec", "first" };
		assertArrayEquals(expected1, count.getItemsByCounter(1, 2).toArray());
		count.addCounter("sec");
		count.addCounter("third");
		count.addCounter("third");
		count.addCounter("third");

		assertArrayEquals(expected, count.getItemsByCounter(1, 2).toArray());

		String[] expected2 = { "sec", "third" };
		assertArrayEquals(expected2, count.getItemsByCounter(2, 3).toArray());
	}
}
