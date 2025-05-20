class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int diff[]=new int[nums.length];
        int k=0;
        for(int arr[]:queries){
            int lef=arr[0];
            int righ=arr[1];
           
            diff[lef]+=1;
            if(righ+1 < nums.length){
                diff[righ+1]+=-1;
            }
        }
        int result[]=new int[nums.length];
        result[0]=diff[0];
        for(int i=1;i<result.length;i++){
            result[i]=result[i-1]+diff[i];
        }
        for(int i=0;i<result.length;i++){
            if(result[i] < nums[i]){
                return false;
            }
        }
        return true;
    }
}