class Solution {
    public long countSubarrays(int[] nums, long k) {
       int si=0;
       int ei=0;
       long ans=0;
       long sum=0;
       while(ei < nums.length){
           sum=sum+nums[ei];
           while(sum*(ei-si+1) >= k){
              sum=sum-nums[si];
              si++;
           }
           ans+=(ei-si+1);
           ei++;
       }
       return ans;
    }
}