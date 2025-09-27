class Solution {
    public int minCostClimbingStairs(int[] cost) {
         int dp[]=new int[cost.length+1];
        //  Arrays.fill(dp,-1);
        //  return Math.min(solve(cost,0,dp),solve(cost,1,dp));
        return bottom_up(cost);
    }
    // public static int solve(int cost[],int idx,int dp[]){
    //     if(idx>=cost.length){
    //         return 0;
    //     }
    //     if(dp[idx]!=-1){
    //         return dp[idx];
    //     }
    //     int one=cost[idx]+solve(cost,idx+1,dp);
    //     int two=cost[idx]+solve(cost,idx+2,dp);
    //     return dp[idx]=Math.min(one,two);
    // }
    public static int bottom_up(int cost[]){
        int n=cost.length;
        int dp[]=new int[n+1];
        dp[n]=0;
        dp[n-1]=cost[n-1];

        for(int i=n-2;i>=0;i--){
            int one=cost[i]+dp[i+1];
            int two=cost[i]+dp[i+2];
            dp[i]=Math.min(one,two);

        }
        return Math.min(dp[0],dp[1]);
    }
}