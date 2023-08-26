package telran.interviews;

import java.util.Comparator;

//Requirement: all methods must have complexity O[1]
public class MyStack<T> {
	// TODO insert the required fields
	public MyStack(Comparator<T> comp) {
		// TODO comparator for comparing two objects of a class T
	}

	public MyStack() {
		// TODO for comparing in the natural order (Comparable)
	}

	public void push(T element) {
		// TODO adds element to the stack's top (last element of the stack)
	}

	public T pop() {
		// TODO removes the stack's top element and returns it out
		// In the case no elements exist in the stack the method throws exception
		// NoSuchElementException
		return null;
	}

	public boolean isEmpty() {
		// TODO returns true if the stack is empty otherwise false
		return false;
	}

	public T getMax() {
		// TODO returns maximal element from the stack
		// In the case no elements exist in the stack the method throws exception
		// NoSuchElementException
		return null;
	}
}
