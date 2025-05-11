class Solution {
    public boolean threeConsecutiveOdds(int[] nums) {
        if(nums.length==3){
            if(nums[0]%2!=0 && nums[1]%2!=0 && nums[2]%2!=0){
                return true;
            }
        }
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]%2!=0 && nums[i+1]%2!=0 && nums[i+2]%2!=0){
                return true;
            }
        }
        return false;
    }
}