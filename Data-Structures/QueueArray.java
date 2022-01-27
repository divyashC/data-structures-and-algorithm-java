package practicalExam;

//O(1), O(n)

public class QueueArray {

	int queue[] = new int[5];
	int size;
	int front;
	int back;

	public void enqueue(int data) {
		queue[back] = data;
		back++;
		size++;
	}

	public int dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		int data = queue[front];
		front++;
		size--;
		return data;

	}

	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		return queue[front];
	}

	public void show() {
		System.out.print("The items in the queue are: ");
		for (int i = 0; i < size; i++) {
			System.out.print(queue[front + i] + " ");
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {

		QueueArray queue = new QueueArray();

		System.out.println("isEmpty: " + queue.isEmpty());

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);

		queue.show();
		System.out.println();

		System.out.println("isEmpty: " + queue.isEmpty());

		System.out.println("The lenth of the queue is: " + queue.size());

		System.out.println("After removing an item:");
		queue.dequeue();
		queue.show();

		System.out.println();
		System.out.println("The top element is :" + queue.peek());

		System.out.println("The length of the queue is " + queue.size());

	}

}
