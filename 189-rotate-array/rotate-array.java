class Solution {
    public void rotate(int[] arr, int k) {
       int n = arr.length;
		k = k % n;
		Reverse(arr, n - k, n - 1);// last k element
        Reverse(arr, 0, n - k - 1);// first n-k element
		Reverse(arr, 0, n - 1);// All element

    }
    public static void Reverse(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		while (i < j) {// for(; i<j; i++,j--)
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
}