class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=6;i++){
            int temp = find(tops,bottoms,i);
            int temp1 = find(bottoms,tops,i);
            ans = Math.min(ans,Math.min(temp,temp1));
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int find(int []tops,int []bottoms,int val){
        int ans = Integer.MAX_VALUE;
        int count = 0;
        for(int i=0;i<tops.length;i++){
            if(tops[i]==val){
                continue;
            }
            if(bottoms[i]==val){
                count++;
            }else{
                return ans;
            }
        }
        return count;
    }
}