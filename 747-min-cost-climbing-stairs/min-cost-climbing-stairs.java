class Solution {
    public int minCostClimbingStairs(int[] cost) {
         int dp[]=new int[cost.length+1];
         Arrays.fill(dp,-2);
         return Math.min(solve(cost,0,dp),solve(cost,1,dp));
    }
    public int solve(int cost[],int idx,int dp[]){
        if(idx>=cost.length){
            return 0;
        }
        if(dp[idx]!=-2){
            return dp[idx];
        }
        int one_step=cost[idx]+solve(cost,idx+1,dp);
        int two_step=cost[idx]+solve(cost,idx+2,dp);
        return dp[idx]= Math.min(one_step,two_step);
    }
}