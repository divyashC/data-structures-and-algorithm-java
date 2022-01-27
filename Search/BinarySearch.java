package practicalExam;

import java.util.Arrays;

// O(log n)

public class BinarySearch {

	public int binarySearch(int[] arr, int start, int end, int value) {

		int mid;
		if (end == 0) {
			return -1;
		} else {
			mid = (start + end) / 2;
			if (arr[mid] == value) {
				return mid;
			} else if (arr[mid] > value) {
				return binarySearch(arr, start, mid - 1, value);
			} else {
				return binarySearch(arr, mid + 1, end, value);
			}
		}
	}

	public static void main(String[] args) {

		int[] nums = { 1, 4, 7, 18, 21, 32, 56, 75, 99, 105 };
		BinarySearch search = new BinarySearch();
		System.out.println("Array: " + Arrays.toString(nums));
		System.out.println("The Index of Item '105' is: " + search.binarySearch(nums, 0, nums.length - 1, 105));
		System.out.println("The Index of Item '18' is: " + search.binarySearch(nums, 0, nums.length - 1, 18));
		System.out.println("The Index of Item '0' is: " + search.binarySearch(nums, 0, nums.length - 1, 0));

	}

}
