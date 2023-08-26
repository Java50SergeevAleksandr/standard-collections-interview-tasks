package telran.interviews;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

//Requirement: all methods must have complexity O[1]
public class MyStack<T> {
	private LinkedList<T> listStack;
	private LinkedList<T> maxValues;
	private Comparator<T> comp;

	public MyStack(Comparator<T> comp) {
		listStack = new LinkedList<>();
		maxValues = new LinkedList<>();
		this.comp = comp;
	}

	@SuppressWarnings("unchecked")
	public MyStack() {
		this((Comparator<T>) Comparator.naturalOrder());
	}

	public void push(T element) {
		listStack.push(element);
		
		if (maxValues.isEmpty() || comp.compare(element, maxValues.peek()) >= 0) {
			maxValues.push(element);
		}
	}

	public T pop() {
		// Throws NoSuchElementException
		T element = listStack.pop();
		
		if (comp.compare(element, maxValues.peek()) == 0) {
			maxValues.pop();
		}
		return element;
	}

	public boolean isEmpty() {
		return listStack.isEmpty();
	}

	public T getMax() {
		// Throws NoSuchElementException
		return maxValues.getFirst();
	}
}
