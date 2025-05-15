class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int prefix[]=new int[nums.length];
        int n=nums.length;
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int result[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
           int left_sum=prefix[i]-nums[i]; // 0 to i-1 ka sum...
           int right_sum=prefix[n-1]-prefix[i]; // i+1 se lekar n-1 ka sum

           result[i]=(nums[i]*i)-left_sum+right_sum-(nums[i]*(n-i-1));
        }
        return result;

    }
}