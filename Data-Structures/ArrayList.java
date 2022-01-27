package practicalExam;

import java.util.Arrays;

// O(1), O(n)

public class ArrayList<T> {

	private T[] array;
	private int arrlength = 0;
	private int size = 0;

	public void set(int i, T item) {
		array[i] = item;
	}

	public T get(int i) {
		return array[i];
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return arrlength;
	}

	public void add(T item) {
		if (arrlength + 1 > size) {
			if (size == 0) {
				size = 1;
			} else {
				size += 1;
			}

			@SuppressWarnings("unchecked")
			T[] new_arr = (T[]) new Object[size];
			for (int i = 0; i < arrlength; i++) {
				new_arr[i] = array[i];
			}
			array = new_arr;
		}
		array[arrlength++] = item;
	}

	public boolean remove(Object obj) {
		for (int i = 0; i < arrlength; i++) {
			if (array[i].equals(obj)) {
				removeAt(i);
				return true;
			}
		}
		return false;
	}

	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}

	public T removeAt(int index) {

		if (index < 0 && index >= arrlength) {
			throw new IndexOutOfBoundsException();
		}

		T temp = array[index];

		@SuppressWarnings("unchecked")
		T[] new_arr = (T[]) new Object[arrlength - 1];

		for (int i = 0, j = 0; i < arrlength; i++, j++) {
			if (i == index) {
				j--;
			} else {
				new_arr[j] = array[i];
			}
		}

		array = new_arr;
		size = --arrlength;
		return temp;
	}

	public void clear() {
		array = null;
		arrlength = 0;
	}

	public int indexOf(Object obj) {
		for (int i = 0; i < arrlength; i++) {
			if (array[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}

	public String asString() {
		return Arrays.toString(array);
	}

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();

		System.out.println(numbers.asString());
		System.out.println("isEmpty: " + numbers.isEmpty());

		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		System.out.println(numbers.asString());

		numbers.set(1, 100);
		numbers.add(5);
		System.out.println(numbers.asString());

		System.out.println("Size: " + numbers.size());
		System.out.println(numbers.get(4));

		numbers.remove(5);
		System.out.println(numbers.asString());

		System.out.println("Index of '100' : " + numbers.indexOf(100));

		numbers.removeAt(3);
		System.out.println(numbers.asString());

		System.out.println("Contains '2'': " + numbers.contains(2));

		System.out.println("Before Clear: " + numbers.asString());
		numbers.clear();
		System.out.println("After Clear: " + numbers.asString());
	}
}