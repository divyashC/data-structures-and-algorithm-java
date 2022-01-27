package practicalExam;

import java.util.Arrays;

// O(n^2)

public class BubbleSort {

	public void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {

		BubbleSort sort = new BubbleSort();

		System.out.println("Bubble Sort");
		int[] arr = { 25, 55, 45, 35, 15, 05, 90, 65, 85, 75 };
		System.out.println("Original Array: " + Arrays.toString(arr));
		sort.bubbleSort(arr);
		System.out.println("Sorted Array  : " + Arrays.toString(arr));

	}

}
