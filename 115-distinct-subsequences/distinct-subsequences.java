class Solution {
    public int numDistinct(String s, String t) {
        int dp[][]=new int[s.length()][t.length()];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
       return  solve(s,s.length()-1,t,t.length()-1,dp);
    }

    public static int solve(String s,int i,String tar,int j,int dp[][]){
           if(j < 0){
               return 1;
           }
           if(i<0){
              return 0;
           }
           if(dp[i][j]!=-1){
              return dp[i][j];
           }
           int pick=0,non_pick=0;
           if(s.charAt(i)==tar.charAt(j)){
              pick=solve(s,i-1,tar,j-1,dp); // no infinite supply
           }
           non_pick=solve(s,i-1,tar,j,dp);
           return dp[i][j]=pick+non_pick;

    }
}