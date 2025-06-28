class Solution {
    public int maxCoins(int[] nums) {
         int n=nums.length;
         int arr[]=new int[n+2];
         arr[0]=1;
         arr[n+1]=1;

         for(int i=0;i<nums.length;i++){
            arr[i+1]=nums[i];
         }
         int dp[][]=new int[n+2][n+2];
         for(int ar[]:dp){
            Arrays.fill(ar,-1);
         }
         return solve(arr,1,n,dp);
    }
    public int solve(int arr[],int i,int j,int dp[][]){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        for(int k=i;k<=j;k++){
            int temp=arr[i-1]*arr[k]*arr[j+1]+solve(arr,i,k-1,dp)+solve(arr,k+1,j,dp);
            ans=Math.max(temp,ans);
        }
        dp[i][j]=ans;
        return ans;

    }
}