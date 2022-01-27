package practicalExam;

import java.util.Arrays;

// O(n^2)

public class SelectionSort {

	public void selectionSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}

	}

	public static void main(String[] args) {

		SelectionSort sort = new SelectionSort();

		System.out.println("Selection Sort");
		int[] arr = { 2, 5, 4, 3, 1, 0, 9, 6, 8, 7 };
		System.out.println("Original Array: " + Arrays.toString(arr));
		sort.selectionSort(arr);
		System.out.println("Sorted Array  : " + Arrays.toString(arr));

	}

}
