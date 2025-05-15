class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int prefix[]=new int[nums.length];
        prefix[0]=nums[0];
        int n=nums.length;
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int res[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
             int leftsum=prefix[i]-nums[i]; // 0 to o=i-1;
             int rightsum=prefix[n-1]-prefix[i]; //i+1 to n-1....

             int left_con=(nums[i]*i)-leftsum;
             int right_con=rightsum-(nums[i]*(n-i-1));
             res[i]=left_con+right_con;
        }
        return res;
    }
}