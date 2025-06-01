class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
          int old_color=image[sr][sc];
          if(old_color==color){
            return image;
          }
          Queue<int[]> q=new LinkedList<>();
          q.add(new int[]{sr,sc});
          image[sr][sc]=color;
          while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
               int arr[]=q.poll();
               int row=arr[0];
               int col=arr[1];

               int r[]={-1,0,1,0};
               int c[]={0,-1,0,1};

               for(int p=0;p<r.length;p++){
                   int new_r=r[p]+row;
                   int new_col=c[p]+col;

                   if(new_r>=0 && new_r<image.length && new_col>=0 && new_col < image[0].length && image[new_r][new_col]==old_color){
                        q.add(new int[]{new_r,new_col});
                        image[new_r][new_col]=color;
                   }
               }
            }
          }
          return image;
    }
}