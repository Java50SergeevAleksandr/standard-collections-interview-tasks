package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.interviews.Connection;
import telran.interviews.ConnectionsPoolImpl;

class ConnectionsPoolTest {
	Connection con1 = new Connection(1, "", 200);
	Connection con2 = new Connection(2, "11", 300);
	Connection con3 = new Connection(3, "22", 400);
	ConnectionsPoolImpl testPool;

	@BeforeEach
	void setUp() throws Exception {
		testPool = new ConnectionsPoolImpl(2);

	}

	@Test
	void test() {
		assertTrue(testPool.addConnection(con1)); 
		assertTrue(testPool.addConnection(con2));
		assertFalse(testPool.addConnection(con2));
		assertEquals(con1, testPool.getConnection(1));
		assertTrue(testPool.addConnection(con3));
		assertNull(testPool.getConnection(2));
	}

}
