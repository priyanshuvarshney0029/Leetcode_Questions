class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max_diff=Integer.MIN_VALUE;
         for(int i=0;i<nums.length-1;i++){
               if(max_diff < Math.abs(nums[i]-nums[i+1])){
                   max_diff= Math.abs(nums[i]-nums[i+1]);
               }
         }  
         if(Math.abs(nums[nums.length-1]-nums[0]) > max_diff){
             return Math.abs(nums[nums.length-1]-nums[0]);
         }
         return max_diff;
    }
}