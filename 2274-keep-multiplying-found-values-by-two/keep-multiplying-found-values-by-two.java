class Solution {
    public int findFinalValue(int[] nums, int original) {
       Arrays.sort(nums);
       int ans=0;
       while(Bs(nums,original)){
           original=2*original;
           ans=original;
       }
       return ans==0 ? original : ans;

    }
    public boolean Bs(int nums[],int tar){
        int low=0;
        int high=nums.length-1;
        while(low <= high){
            int mid=low+(high-low)/2;
            if(nums[mid]==tar){
                return true;
            }
            else if(nums[mid] > tar){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
}