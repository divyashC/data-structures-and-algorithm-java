package practicalExam;

import java.util.Arrays;
import java.util.NoSuchElementException;

//O(1), O(n)

public class LinkedList {

	private Node first;
	private Node last;
	private int size;

	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void add(int item) {
		addLast(item);
	}

	public void addFirst(int item) {
		Node node = new Node(item);
		if (isEmpty()) {
			first = last = node;
		} else {
			node.next = first;
			first = node;
		}
		size++;
	}

	public void addLast(int item) {
		Node node = new Node(item);

		if (isEmpty()) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
		size++;
	}

	public int indexOf(int item) {
		int index = 0;
		Node current = first;
		while (current != null) {
			if (current.value == item) {
				return index;
			}
			current = current.next;
			index++;
		}
		return -1;
	}

	public boolean contains(int item) {
		return indexOf(item) != -1;
	}

	public void removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		if (first == last) {
			first = last = null;
		} else {
			Node second = first.next;
			first.next = null;
			first = second;
		}

		size--;
	}

	public void removeLast() {

		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		if (first == last) {
			first = last = null;
		} else {
			Node previous = getPrevious(last);
			last = previous;
			last.next = null;
		}
		size--;

	}

	private Node getPrevious(Node node) {
		Node current = first;
		while (current != null) {
			if (current.next == node) {
				return current;
			}
			current = current.next;
		}
		return null;
	}

	public int size() {
		return size;
	}

	public String asString() {
		int[] array = new int[size];
		Node current = first;
		var index = 0;
		while (current != null) {
			array[index++] = current.value;
			current = current.next;
		}
		return Arrays.toString(array);
	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();

		System.out.println("Is Empty: " + linkedList.isEmpty());
		System.out.println(linkedList.asString());

		linkedList.add(10);
		linkedList.addFirst(0);
		linkedList.addLast(20);
		linkedList.add(30);

		System.out.println("Is Empty: " + linkedList.isEmpty());
		System.out.println(linkedList.asString());

		System.out.println("Size: " + linkedList.size());
		System.out.println("Index of '0': " + linkedList.indexOf(0));

		System.out.println("Removed Last and First");
		linkedList.removeFirst();
		linkedList.removeFirst();

		System.out.println("Contains '0': " + linkedList.contains(0));

	}

}