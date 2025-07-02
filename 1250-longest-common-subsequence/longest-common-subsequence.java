class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]=new int[text1.length()][text2.length()];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return solve(text1,text2,0,0,dp);

    }
    public int solve(String s1,String s2,int i,int j,int dp[][]){
       if(i==s1.length()){
           return 0;
       }
       if(j==s2.length()){
           return 0;
       }
       
        int pick,non_pic=0;
        int ans=0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
           ans=1+solve(s1,s2,i+1,j+1,dp);
        }
        else{
            non_pic=Math.max(solve(s1,s2,i+1,j,dp),solve(s1,s2,i,j+1,dp));
        }
        return dp[i][j]=Math.max(non_pic,ans);
    }
}