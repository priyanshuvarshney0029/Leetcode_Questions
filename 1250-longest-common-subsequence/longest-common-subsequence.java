class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int dp[][]=new int[s1.length()][s2.length()];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
         return lcs(s1,s1.length()-1,s2,s2.length()-1,dp);
    }
    public static int lcs(String s1,int i,String s2,int j,int dp[][]){
         if(i==-1 || j==-1){
             return 0;
         }
         if(dp[i][j]!=-1){
            return dp[i][j];
         }
         int ans=0;
         if(s1.charAt(i)==s2.charAt(j)){
            ans=1+lcs(s1,i-1,s2,j-1,dp);
         }
         else{
            int p1=lcs(s1,i-1,s2,j,dp);
            int p2=lcs(s1,i,s2,j-1,dp);
            ans=Math.max(p1,p2);
         }
         return dp[i][j]=ans;
    }
}