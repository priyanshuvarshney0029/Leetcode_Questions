class Solution {
    public void solveSudoku(char[][] board) {
        // List<List<String>> ans=new ArrayList<>();
       sudukoSolver(board,0,0);

    }
    public static boolean sudukoSolver(char [][]grid,int row,int col) {
		if(col==9) {
			col=0;
			row++;
		}
		if(row==9) {
			// display(grid,ans);
			return true;
		}
		if(grid[row][col]!='.') {
			boolean x=sudukoSolver(grid,row,col+1);
            if(x==true){
                return true;
            }
		}
		else {
			for(char val='1';val<='9';val++) {
				if(isitsafe(grid,row,col,val)==true) {
					grid[row][col]=val;
					boolean x=sudukoSolver(grid,row,col+1);
                    if(x==true){
                        return true;
                    }
					grid[row][col]='.';
					
				}
			}
		}
        return false;
	}

	public static boolean isitsafe(char [][]grid,int row,int col,char val) {
		// row
		for(int i=0;i<grid[0].length;i++) {
			if(grid[row][i]==val) {
				return false;
			}
			
		}
		// col
		for(int i=0;i<grid.length;i++) {
			if(grid[i][col]==val) {
				return false;
			}
		}
		// 3*3 matrix
		int r=row-row%3;
		int c=col-col%3;
		for(int i=r;i<r+3;i++) {
			for(int j=c;j<c+3;j++) {
				if(grid[i][j]==val) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}