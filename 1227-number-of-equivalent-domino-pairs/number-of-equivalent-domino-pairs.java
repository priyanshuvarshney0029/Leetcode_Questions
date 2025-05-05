class Solution {
    public int numEquivDominoPairs(int[][] arr) {
      int[] freq = new int[100];
        int count = 0;
        for (int[] a : arr) {
            int x = Math.min(a[0], a[1]);
            int y = Math.max(a[0], a[1]);
            int key = x * 10 + y;
            count += freq[key];
            freq[key]++;
        }
        return count;
    }
}