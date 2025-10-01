class Solution {
    public int change(int amount, int[] coins) {
          return solve(coins,amount);
    }
    public static int solve(int coins[],int amount){
        int dp[][]=new int[amount+1][coins.length+1];
        
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=1;    // base case
        }

        for(int i=1;i<dp.length;i++){ // amount
            for(int j=1;j<dp[0].length;j++){
                int non_pick=dp[i][j-1];
                int pick=0;

                if(i >= coins[j-1]){
                    pick=dp[i-coins[j-1]][j];
                }
                dp[i][j]=pick+non_pick;
            }
        }
        return dp[dp.length-1][dp[0].length-1];

    }

}