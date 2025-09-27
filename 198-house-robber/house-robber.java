class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        // Arrays.fill(dp,-1);
        return bottom_up(nums,dp);
    }
    public static int solve(int nums[],int idx){
        if(idx<0){
            return 0;

        }
        int chori=nums[idx]+solve(nums,idx-2);
        int not_chori=solve(nums,idx-1);

        return Math.max(chori,not_chori);
    }
    public static int bottom_up(int nums[],int dp[]){
         if(nums.length==1){
            return nums[0];
         }
         dp[0]=nums[0];
         dp[1]=Math.max(nums[0],nums[1]);
         for(int i=2;i<dp.length;i++){
            int chori=nums[i]+dp[i-2];
            int not_Chori=dp[i-1];
            dp[i]=Math.max(chori,not_Chori);
         }
         return dp[dp.length-1];
    }
}