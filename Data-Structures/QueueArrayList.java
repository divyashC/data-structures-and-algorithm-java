package practicalExam;

import java.util.ArrayList;

//O(1), O(n)

public class QueueArrayList {

	ArrayList<Integer> queueList = new ArrayList<Integer>();

	public void enqueue(int item) {
		queueList.add(item);
	}

	public int dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		return queueList.remove(0);
	}

	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		return queueList.get(0);
	}

	public boolean isEmpty() {
		return queueList.size() == 0;
	}

	public int size() {
		return queueList.size();
	}

	public String asString() {
		return queueList.toString();
	}

	public static void main(String[] args) {

		QueueArrayList queue = new QueueArrayList();

		System.out.println("Is Empty: " + queue.isEmpty());

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);

		System.out.println("1, 2, 3, 4, 5 was enqueued");

		System.out.println("Is Empty: " + queue.isEmpty());
		System.out.println("Size: " + queue.size());
		System.out.println("Queue: " + queue.asString());
		System.out.println("Dequeue: " + queue.dequeue());
		System.out.println("Queue: " + queue.asString());
		System.out.println("Peek: " + queue.peek());

	}

}