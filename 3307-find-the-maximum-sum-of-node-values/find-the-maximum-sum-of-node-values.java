class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum=0;
        int count=0;
        int min_minus=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            int t=nums[i]^k;
            if(t>nums[i]){
                sum+=t;
                count++;

            }
            else{
                sum+=nums[i];
            }
            min_minus=Math.min(min_minus,Math.abs(nums[i]-(nums[i]^k)));
        }
        if(count%2!=0){
            return sum-min_minus;
        }
        else{
            return sum;
        }
    }
}