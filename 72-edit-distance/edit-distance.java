class Solution {
    public int minDistance(String word1, String word2) {
        
        return botomup(word1,word2);
    }
    public static int botomup(String s,String t){
        int dp[][]=new int[s.length()+1][t.length()+1];
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<dp.length;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int ans=0;
                if(s.charAt(i-1)==t.charAt(j-1)){
                    ans=dp[i-1][j-1];
                }
                else{
                    int D=dp[i-1][j];
                    int I=dp[i][j-1];
                    int R=dp[i-1][j-1];
                     ans=Math.min(D,Math.min(I,R))+1;
                }
                 dp[i][j]=ans;
            }
        }
        return dp[dp.length-1][dp[0].length-1];

    }
}