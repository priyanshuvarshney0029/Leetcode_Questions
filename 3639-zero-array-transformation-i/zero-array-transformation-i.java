class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int diff[]=new int[nums.length];
        for(int arr[]:queries){
            int lef=arr[0];
            int rig=arr[1];

            diff[lef]+=1;
            if(rig+1 < nums.length){
                diff[rig+1]-=1;
            }
        }
        // 2 step prefix_sum;
        int ans[]=new int[nums.length];
        ans[0]=diff[0];
        for(int i=1;i<nums.length;i++){
            ans[i]=ans[i-1]+diff[i];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>ans[i]){
                return false;
            }
        }
        return true;
    }
}