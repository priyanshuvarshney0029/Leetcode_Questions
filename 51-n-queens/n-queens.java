class Solution {
    public List<List<String>> solveNQueens(int n) {
        char [][]board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        print(board,n,0,ans);
        return ans;
    }
    public void print(char [][]board,int tq,int row,List<List<String>> ans){
        if(tq==0){
            display(board,ans);
            return;
        }
        for(int col=0;col<board[0].length;col++){
            if(isItSafe(board,row,col)){
                board[row][col] = 'Q';
                print(board,tq-1,row+1,ans);
                board[row][col] = '.';
            }
        }
    }
    public boolean isItSafe(char [][]board,int row,int col){
        //checking above column
        int r = row;
        while(r>=0){
            if(board[r][col]=='Q'){
                return false;
            }
            r--;
        }

        //checking above left diagonal
        r = row;
        int c = col;
        while(r>=0 && c>=0){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
            c--;
        }

        //checking above right diagonal
        r = row;
        c = col;
        while(r>=0 && c<board[0].length){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
            c++;
        }

        return true;
    }
    public static void display(char [][]board,List<List<String>> ans){
        List<String> ll = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String str = new String(board[i]);
            ll.add(str);
        }
        ans.add(ll);
    }
}