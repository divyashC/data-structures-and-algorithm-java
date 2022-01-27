package practicalExam;

import java.util.ArrayList;

//O(1), O(n)

public class StackArrayList {

	ArrayList<Integer> arraylist = new ArrayList<Integer>();

	public boolean isEmpty() {
		return arraylist.size() == 0;
	}

	public void push(int item) {
		arraylist.add(item);
	}

	public int pop() {
		return arraylist.remove(arraylist.size() - 1);
	}

	public int peek() {
		return arraylist.get(arraylist.size() - 1);
	}

	public int size() {
		return arraylist.size();
	}

	public String asString() {
		return arraylist.toString();
	}

	public static void main(String[] args) {

		StackArrayList stack = new StackArrayList();

		System.out.println("Is Empty: " + stack.isEmpty());

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		System.out.println("Is Empty: " + stack.isEmpty());
		System.out.println("Size: " + stack.size());
		System.out.println("Stack: " + stack.asString());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Peek: " + stack.peek());
		System.out.println("Stack: " + stack.asString());

	}

}