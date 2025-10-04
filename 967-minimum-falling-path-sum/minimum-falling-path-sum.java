class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        for (int col = 0; col < n; col++) {
            dp[0][col] = grid[0][col];
        }

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int ld = Integer.MAX_VALUE;
                int d = dp[row - 1][col];
                int rd = Integer.MAX_VALUE;

                if (col - 1 >= 0) ld = dp[row - 1][col - 1];
                if (col + 1 < n) rd = dp[row - 1][col + 1];

                dp[row][col] = grid[row][col] + Math.min(d, Math.min(ld, rd));
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            ans = Math.min(ans, dp[n - 1][col]);
        }

        return ans;
    }
}
