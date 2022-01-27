package practicalExam;

import java.util.Arrays;

//O(nlogn)

public class MergeSortLongMethod {

	public void sort(int[] arr, int first, int last) {
		if (first < last) {
			int middle = (first + last) / 2;

			sort(arr, first, middle);
			sort(arr, middle + 1, last);

			merge(arr, first, middle, last);
		}
	}

	public void merge(int[] arr, int first, int middle, int last) {

		int i = 0, j = 0;

		int leftSize = middle - first + 1;
		int rightSize = last - middle;

		int leftHalf[] = new int[leftSize];
		int rightHalf[] = new int[rightSize];

		for (i = 0; i < leftSize; i++) {
			leftHalf[i] = arr[first + i];
		}

		for (i = 0; i < rightSize; i++) {
			rightHalf[i] = arr[middle + 1 + i];
		}

		i = 0;
		j = 0;

		int k = first;

		while (i < leftSize && j < rightSize) {

			if (leftHalf[i] <= rightHalf[j]) {
				arr[k] = leftHalf[i];
				i++;
			} else {
				arr[k] = rightHalf[j];
				j++;
			}
			k++;
		}

		while (i < leftSize) {
			arr[k] = leftHalf[i];
			i++;
			k++;
		}

		while (j < rightSize) {
			arr[k] = rightHalf[j];
			j++;
			k++;
		}

	}

	public static void main(String[] args) {

		MergeSortLongMethod msort = new MergeSortLongMethod();

		int[] arr = { 2, 1, 3, 4, 5, 8, 9, 7, 6 };

		System.out.println("Merge Sort");
		System.out.println("Array Before Sorting  : " + Arrays.toString(arr));
		msort.sort(arr, 0, arr.length - 1);
		System.out.println("Array after Merge Sort: " + Arrays.toString(arr));

	}

}
