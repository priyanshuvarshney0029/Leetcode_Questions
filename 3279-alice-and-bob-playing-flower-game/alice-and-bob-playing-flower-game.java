class Solution {
    public long flowerGame(int n, int m) {
        int odd_n = (n+1)/2;
        int even_n = n/2;
        int odd_m = (m+1)/2;
        int even_m = m/2;
        return (long)odd_n*even_m + (long)even_n*odd_m;
    }
}