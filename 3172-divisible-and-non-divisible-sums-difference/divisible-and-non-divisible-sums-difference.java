class Solution {
    public int differenceOfSums(int n, int m) {
       int t=n/m;
       return (n*(n+1)/2) - m*(t*(t+1)); 
    }
}