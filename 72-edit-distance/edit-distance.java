class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][]=new int[word1.length()][word2.length()];
        for(int ar[]:dp){
            Arrays.fill(ar,-1);
        }
        return solve(word1,word2,0,0,dp);
    }
    public static int solve(String s,String t,int i,int j,int dp[][]){
         if(s.length()==i){ // s wali khaali
            return t.length()-j;
         }
         if(t.length()==j){
            return s.length()-i;
         }
         if(dp[i][j]!=-1){
            return dp[i][j];
         }
         int ans=0;
         if(s.charAt(i)==t.charAt(j)){
            ans=solve(s,t,i+1,j+1,dp);
         }
         else{
            int D=solve(s,t,i+1,j,dp);
            int I=solve(s,t,i,j+1,dp);
            int R=solve(s,t,i+1,j+1,dp);
            ans=Math.min(D,Math.min(I,R))+1;
           dp[i][j]=ans;
            
         }
         return ans;
    }
}