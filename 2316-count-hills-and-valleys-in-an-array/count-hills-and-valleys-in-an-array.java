class Solution {
    public int countHillValley(int[] nums) {
        int i=0;
        int j=1;
        int count=0;
        while(j<nums.length-1){
            if(nums[j]> nums[i]&& nums[j]>nums[j+1]){
                count++; // ye hill mila hian hume
                i=j;
                j++;
            }
            else if(nums[j]<nums[i] && nums[j]<nums[j+1]){
                count++; // velley mili hain ye..
                i=j;
                j++;
            }
            else{
                j++;
            }
        }
        return count;
    }
}