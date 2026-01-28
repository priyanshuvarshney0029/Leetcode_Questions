class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        int si=0;
        int ei=nums.length-1;
        while(ei >= si){
          int res=nums[ei]+nums[si];
          sum=Math.max(sum,res);
          si++;
          ei--;
        }
        return sum;
    }
}