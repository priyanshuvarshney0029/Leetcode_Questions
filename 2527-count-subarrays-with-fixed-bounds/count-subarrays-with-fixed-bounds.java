class Solution {
    public long countSubarrays(int[] nums, int mink, int maxk) {
        long ans=0;
        int min_pos=-1;
        int max_pos=-1;
        int dushman=-1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]< mink || nums[i]>maxk){
                dushman=i;
            }
            if(nums[i]==mink){
                min_pos=i;
            }
            if(nums[i]==maxk){
                max_pos=i;
            }
            long small=Math.min(min_pos,max_pos);
            long temp=small-dushman;
            ans+=(temp<=0) ? 0:temp;
        }
        return ans;
    }
}