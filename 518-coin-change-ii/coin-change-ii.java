class Solution {
    public int change(int amount, int[] coins) {
        int dp[][]=new int[amount+1][coins.length+1];

        // abse case fill
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
              int  non_pick=dp[i][j-1];
              int pick=0;
              if(i>=coins[j-1]){
                   pick=dp[i-coins[j-1]][j];
                }
                dp[i][j]=pick+non_pick;
            }
        }
        return dp[dp.length-1][dp[0].length-1];


        // return solve(amount,coins,coins.length-1);
    }
    public int solve(int amt,int coins[],int idx){
        if(amt==0){
            return 1;
        }
        if(idx<0){      //idx==coins.length // ye bhi kar skte h
           return 0;
        }
        int pick=0,non_pick=0;
        if(amt>=coins[idx]){
            pick=solve(amt-coins[idx],coins,idx);
        }
        non_pick=solve(amt,coins,idx-1);
        return pick+non_pick;
    }
}