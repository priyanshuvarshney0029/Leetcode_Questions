class Solution {
    public String triangleType(int[] nums) {
        int sum=nums[1]+nums[2];
        int sum2=nums[0]+nums[1];
        int sum3=nums[0]+nums[2];
     if(nums[0]>=sum){
        return "none";
      }
      else if(nums[2]>=sum2){
         return "none";
      }
      else if(nums[1]>=sum3){
         return "none";
      }
       else if(nums[0]==nums[1] && nums[1]==nums[2] && nums[0]==nums[2]){
            return "equilateral";
        }
        else if(nums[0]==nums[1] || nums[1]==nums[2] || nums[0]==nums[2]){
            return "isosceles";
        }
        else{
            return "scalene";
        }
      
    }
}