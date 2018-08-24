package algorithms;

public class QuickSort {

	// 18:59
	// 19:04
	static void quicksort(int[] a) {
		// null and empty checks
		sort(a, 0, a.length - 1);
	}

	static void sort(int[] a, int low, int high) {
		if (low < high) {
			int p = partition(a, low, high);
			sort(a, low, p - 1);
			sort(a, p + 1, high);
		}
	}

	static int partition(int[] A, int low, int high) {
		// pick last element as pivot
		int pivot = high;

		// initialize variables
		int i = low - 1;
		int j = low;

		while (j < pivot) {
			if (A[j] <= A[pivot]) {
				i++;
				swap(A, i, j);
			}

			j++;
		}

		i++;
		swap(A, i, pivot);
		return i;

	}

	static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String[] args) {

		int[] a = { 10, 80, 30, 90, 40, 50, 70 };
		quicksort(a);
		for (int i : a)
			System.out.print(i + ",");

		System.out.println();

		int[] a2 = { 90, 70, 60, 50, 40, 20, 10 };
		quicksort(a2);
		for (int i : a2)
			System.out.print(i + ",");

		System.out.println();

		int[] a3 = { 10, 20, 30, 40, 50, 60 };
		quicksort(a3);
		for (int i : a3)
			System.out.print(i + ",");

	}

}
