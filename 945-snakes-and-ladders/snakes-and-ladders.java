class Solution {
    public int snakesAndLadders(int[][] board) {
         Queue<Integer> q=new LinkedList<>();
         int n=board.length;
         HashSet<Integer> visited=new HashSet<>();
         q.add(1);
         visited.add(1);
         int steps=0;
         

         while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int rv=q.poll();

                if(rv==n*n){
                    return steps;
                }
                for(int t=1;t<=6;t++){
                    if(rv+t > n*n){
                        break;
                    }
                    int nex_val=rv+t;
                    int[] pos=getCoordinates(nex_val, n);
                    int row=pos[0];
                    int col=pos[1];
                    int finalPos = (board[row][col] == -1) ? nex_val: board[row][col];

                    if (!visited.contains(finalPos)) {
                        q.add(finalPos);
                        visited.add(finalPos);
                    }
                } 
             }
             steps++;
               
            }
            return -1;
    }
    private int[] getCoordinates(int num, int n) {
        int r = (num - 1) / n;
        int c = (num - 1) % n;
        int row = n - 1 - r;
        int col = (r % 2 == 0) ? c : n - 1 - c;
        return new int[]{row, col};
    }
}