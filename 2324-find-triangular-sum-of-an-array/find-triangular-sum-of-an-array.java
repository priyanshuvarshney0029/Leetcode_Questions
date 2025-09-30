class Solution {
    public int triangularSum(int[] nums) {
        while(nums.length > 0){
             if(nums.length==1){
                return nums[0];
             }
             int arr[]=new int[nums.length-1];
             for(int j=0;j<arr.length;j++){
                arr[j]=(nums[j]+nums[j+1])%10;
             }
             nums=arr;
        }
        return 0;
    }
}