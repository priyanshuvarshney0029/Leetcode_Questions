class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max_ele=Integer.MIN_VALUE;
        int max_index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] >= max_ele){
                max_ele=nums[i];
                max_index=i;
            }
        }
        int count=0;
        long ans=0;
        int si=0;
        int ei=0;
        while(ei < nums.length){
            if(nums[ei]==max_ele){
                count++;
            }

            while(count==k){
                ans+=nums.length-ei;
                if(nums[si]==max_ele){
                    count--;
                }
                si++;
            }
            ei++;
        }
        
        return ans;
    }
}