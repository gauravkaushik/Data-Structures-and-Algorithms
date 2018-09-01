package leetcode.easy.rotatearray;

public class Solution {

	// 20:31
	// 21:03
	// 21:07

	//my solution
	public void rotate(int[] A, int k) {
		if (A == null || A.length < 2 || k == 0 || k == A.length)
			return;

		int N = A.length;
		int[] result = new int[N];
		int r = 0;
		k = k % N;
		for (int i = N - k; i < N; i++)
			result[r++] = A[i];
		for (int i = 0; i < N - k; i++)
			result[r++] = A[i];
		for (int i = 0; i < N; i++)
			A[i] = result[i];
	}
	
	//leetcode efficient sample solution
	public void rotateWithoutExtraSpace(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }
    
    public void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
