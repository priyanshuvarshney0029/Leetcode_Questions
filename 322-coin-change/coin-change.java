class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
               if(i>=coins[j]){
                 int rem=i-coins[j];
                 if(dp[rem]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],dp[rem]+1);
                 }
               }
            }
        }
       System.out.println(dp[amount]);
       return  dp[amount]!=Integer.MAX_VALUE ?  dp[amount] :-1;
    }
}