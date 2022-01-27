package practicalExam;

import java.util.Arrays;

//O(1), O(n)

public class StackArray {

	public int[] items = new int[5];
	public int count;

	public void push(int variables) {
		if (count == items.length) {
			throw new StackOverflowError();
		}
		items[count] = variables;
		count++;
	}

	public int pop() {
		if (count == 0) {
			throw new IllegalStateException();
		}
		count--;
		return items[count];
	}

	public int peek() {
		if (count == 0) {
			throw new IllegalStateException();
		}
		return items[count - 1];
	}

	@Override
	public String toString() {
		return Arrays.toString(items);
	}

	public int size() {
		return items.length;
	}

	public static void main(String[] args) {
		StackArray stack = new StackArray();

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		System.out.println("The added items are :" + stack);

		System.out.println("The length of a stack before removing an item is " + stack.size());

		System.out.println("The top element is :" + stack.peek());

		stack.pop();
		stack.pop();
		System.out.println("Items after removing the top item are :" + stack);

		System.out.println("The length of a stack after removing an item is " + stack.size());

	}

}