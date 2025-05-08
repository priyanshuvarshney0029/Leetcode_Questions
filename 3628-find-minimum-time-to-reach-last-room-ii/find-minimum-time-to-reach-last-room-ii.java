class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;
        int [][]time = new int[m][n];
        for(int []x:time){
            Arrays.fill(x,Integer.MAX_VALUE);
        }
        time[0][0] = 0;
        int []row = {0,1,0,-1};
        int []col = {1,0,-1,0};
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        //(time,row,col)
        pq.add(new int[]{0,0,0,0});
        while(!pq.isEmpty()){
            int t = pq.peek()[0];
            int r = pq.peek()[1];
            int c = pq.peek()[2];
            int move = pq.peek()[3];
            pq.poll();

            if(r==m-1 && c==n-1){
                return t;
            }
            
            for(int i=0;i<4;i++){
                int newR = r+row[i];
                int newC = c+col[i];
                if(newR>=0 && newC>=0 && newR<m && newC<n){
                    int diff = moveTime[newR][newC]-t;
                    if(diff<=0){
                        diff = 0;
                    }
                    int newTime = diff+t;
                    if((move+1)%2==1){
                        newTime+=1;
                    }else{
                        newTime+=2;
                    }
                    if(newTime<time[newR][newC]){
                        time[newR][newC] = newTime;
                        pq.add(new int[]{newTime,newR,newC,move+1});
                    }
                }
            }
        }
        return -1;
    }
}