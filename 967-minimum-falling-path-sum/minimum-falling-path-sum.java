class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int dp[][]=new int[matrix.length][matrix.length];
        for(int arr[]:dp){
            Arrays.fill(arr,-100000);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            ans=Math.min(ans,solve(matrix,0,i,dp));
        }
        return ans;
    }
    public static int solve(int grid[][],int cr,int cc,int dp[][]){
        if(cc >= grid[0].length || cc < 0){
            return Integer.MAX_VALUE;
        }
        if(cr==grid.length-1){
            return grid[cr][cc];
        }
        if(dp[cr][cc]!=-100000){
            return dp[cr][cc];
        }
        int ld=solve(grid,cr+1,cc-1,dp);
        int d=solve(grid,cr+1,cc,dp);
        int rd=solve(grid,cr+1,cc+1,dp);
        return dp[cr][cc]=Math.min(ld,Math.min(d,rd))+grid[cr][cc];
    }
}