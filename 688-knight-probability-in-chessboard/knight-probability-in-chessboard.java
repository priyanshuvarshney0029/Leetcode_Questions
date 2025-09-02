class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        Map<String,Double> map=new HashMap<>();
        return solve(n, k, row, column,map);
    }

    public static double solve(int n, int k, int row, int col, Map<String,Double> map) {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            return 0.0;
        }
        if (k == 0) {
            return 1.0;
        }
        String key=k+","+row+","+col;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int[][] moves = {
            {2, 1}, {2, -1},{-2, 1},{-2, -1},
            {1, 2}, {1, -2},{-1, 2},{-1, -2}
        };

        double res = 0.0;
        for (int[] m : moves) {
            res += solve(n, k - 1, row + m[0], col + m[1],map);
        }
        res=res/8.0;
        map.put(key,res);
        return res;
    }
}