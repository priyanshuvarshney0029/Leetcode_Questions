class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][]=new int[grid.length][grid[0].length];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return solve(grid,0,0,grid.length-1,grid[0].length-1,dp);
    }
    public static int solve(int grid[][],int cr,int cc,int row,int col,int dp[][]){
         if(cr>row || cc > col){
             return Integer.MAX_VALUE;
         }
         if(cr==row && cc==col){
             return grid[cr][cc];
         }
         if(dp[cr][cc]!=-1){
            return dp[cr][cc];
         }
         int right=solve(grid,cr,cc+1,row,col,dp);
         int down=solve(grid,cr+1,cc,row,col,dp);

         return dp[cr][cc]=Math.min(right,down)+grid[cr][cc];
    }
}