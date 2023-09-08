package telran.interviews;

import java.util.*;

/**
 * All methods of the class should have complexity O[1]
 * 
 * @author User
 *
 * @param <T>
 */
public class MyArray<T> {

	Map<Integer, T> map;
	T allVal = null;
	int size;

	public MyArray(int size) {
		this.size = size;
		map = new HashMap<>(size);
	}

	/**
	 * sets all array's elements with a given value
	 * 
	 * @param value
	 */
	public void setAll(T value) {
		map = new HashMap<>(size);
		allVal = value;
	}

	/**
	 * 
	 * @param index
	 * @return value at given index or null if index is wrong
	 */
	public T get(int index) {
		T res = null;
		if (index < size && index > -1) {
			res = map.getOrDefault(index, allVal);
		}

		return res;
	}

	/**
	 * sets a given value at a given index throws IndexOutOfBoundsException in the
	 * case of wrong index
	 * 
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		map.put(index, value);
	}
}