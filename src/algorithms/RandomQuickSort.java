package algorithms;

public class RandomQuickSort {

	static void randomizedquicksort(int[] a) {
		// null and empty checks
		randomizedsort(a, 0, a.length - 1);
	}

	static void randomizedsort(int[] a, int low, int high) {
		if (low < high) {
			int randomIdx = getRandomNumberBetweenRange(low, high);
			swap(a, high, randomIdx);
			int p = partition(a, low, high);
			randomizedsort(a, low, p - 1);
			randomizedsort(a, p + 1, high);
		}
	}

	private static int getRandomNumberBetweenRange(int min, int max) {
		// TODO Auto-generated method stub
		return (int) (Math.random() * ((max - min) + 1) + min);
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

		System.out.println("When input is randomly arranged");
		int[] a1 = { 10, 80, 30, 90, 40, 50, 70, 60, 20 };
		print(a1);
		randomizedquicksort(a1);
		System.out.println("Output : ");
		print(a1);

		System.out.println();

		System.out.println("When input is arranged in decending order");
		int[] a2 = { 90, 80, 70, 60, 50, 40, 30, 20, 10, };
		print(a2);
		randomizedquicksort(a2);
		System.out.println("Output : ");
		print(a2);

		System.out.println();

		int[] a3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		System.out.println("When input is arranged in ascending order");
		print(a3);
		randomizedquicksort(a3);
		System.out.println("Output : ");
		print(a3);

	}

	static void print(int[] a) {
		for (int i : a)
			System.out.print(i + " ");
		System.out.println();
		

	}

}
