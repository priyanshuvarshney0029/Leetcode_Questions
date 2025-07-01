class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int count=1;
        int st=pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            int end=pairs[i][0];
            if(end > st){
                count++;
                st=pairs[i][1];
            }
        }
        return count;

    }
}