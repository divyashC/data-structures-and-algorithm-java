package practicalExam;

import java.util.Arrays;

//O(n^2)

public class InsertionSort {

	public void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int current = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > current) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = current;
		}
	}

	public static void main(String[] args) {

		InsertionSort sort = new InsertionSort();

		System.out.println("Insertion Sort");
		int[] arr = { 20, 50, 40, 30, 10, 00, 90, 60, 80, 70 };
		System.out.println("Original Array: " + Arrays.toString(arr));
		sort.insertionSort(arr);
		System.out.println("Sorted Array  : " + Arrays.toString(arr));

	}

}
