package practicalExam;

import java.util.Arrays;

//O(nlogn)

public class MergeSort {

	public void sort(int[] arr) {

		if (arr.length < 2) {
			return;
		}

		int middle = arr.length / 2;

		int[] left = new int[middle];
		for (int i = 0; i < middle; i++) {
			left[i] = arr[i];
		}

		int[] right = new int[arr.length - middle];
		for (int i = middle; i < arr.length; i++) {
			right[i - middle] = arr[i];
		}
		sort(left);
		sort(right);
		merge(left, right, arr);

	}

	public void merge(int[] left, int[] right, int[] arr) {

		int i = 0, j = 0, k = 0;

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}

		while (i < left.length) {
			arr[k++] = left[i++];
		}

		while (j < right.length) {
			arr[k++] = right[j++];
		}

	}

	public static void main(String[] args) {

		MergeSort msort = new MergeSort();

		int[] arr = { 2, 1, 3, 4, 5, 8, 9, 7, 6 };

		System.out.println("Merge Sort");
		System.out.println("Array Before Sorting  : " + Arrays.toString(arr));
		msort.sort(arr);
		System.out.println("Array after Merge Sort: " + Arrays.toString(arr));

	}

}
