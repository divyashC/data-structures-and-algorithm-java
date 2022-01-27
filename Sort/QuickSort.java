package practicalExam;

import java.util.Arrays;

// O(nlogn)

public class QuickSort {

	public void quickSort(int[] arr, int start, int end) {

		if (start < end) {
			int index = Partition(arr, start, end);
			quickSort(arr, start, index - 1);
			quickSort(arr, index + 1, end);
		}

	}

	public int Partition(int[] arr, int start, int end) {

		int pivot = arr[end];
		int index = start - 1;

		for (int i = start; i <= end; i++) {
			if (arr[i] <= pivot) {
				index++;
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			}
		}

		return index;

	}

	public static void main(String[] args) {

		QuickSort sort = new QuickSort();

		int[] arr = { 2, 1, 3, 4, 5, 8, 9, 7, 6 };

		System.out.println("Quick Sort");
		System.out.println("Array Before Sorting  : " + Arrays.toString(arr));
		sort.quickSort(arr, 0, arr.length - 1);
		System.out.println("Array after Quick Sort: " + Arrays.toString(arr));
	}

}
