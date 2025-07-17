class Solution {
    public int maximumLength(int[] nums, int k) {
        int [][]dp = new int[nums.length][k];
        for(int []x:dp){
            Arrays.fill(x,1);
        }
        int ans = 0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                int mod = (nums[i]+nums[j])%k;
                dp[i][mod] = Math.max(dp[i][mod],dp[j][mod]+1);
                ans = Math.max(ans,dp[i][mod]);
            }
        }
        return ans;
    }
}