package practicalExam;

import java.util.Arrays;

//O(1), O(n)

public class SequentialSearch {

	public int sequentialSearch(int[] arr, int value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 10, 9, 3, 4, 8, 7, 5, 6 };

		SequentialSearch search = new SequentialSearch();

		System.out.println("Array: " + Arrays.toString(nums));
		System.out.println("The Index of Item '10' is: " + search.sequentialSearch(nums, 10));
		System.out.println("The Index of Item '5' is: " + search.sequentialSearch(nums, 5));
	}

}