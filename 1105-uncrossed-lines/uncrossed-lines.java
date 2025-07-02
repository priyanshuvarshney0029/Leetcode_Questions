class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int dp[][]=new int[nums1.length][nums2.length];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return solve(nums1,nums2,0,0,dp);
    }
    public static int solve(int nums1[],int nums2[],int i,int j,int dp[][]){
        if(i==nums1.length){
            return 0;
        }
        if(j==nums2.length){
            return 0;
        }
        int pick=0;
        int nonpick=0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
       if(nums1[i]==nums2[j]){
             pick=1+solve(nums1,nums2,i+1,j+1,dp);
       }
       else{
          nonpick=Math.max(solve(nums1,nums2,i,j+1,dp),solve(nums1,nums2,i+1,j,dp));
       }
       return dp[i][j]=Math.max(pick,nonpick);
      
    }
}