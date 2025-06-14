class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low=0;
        int high=nums[nums.length-1]-nums[0];
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(is_it_pos(nums,mid,p)){
                ans=mid;
                high=mid-1;

            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean is_it_pos(int nums[],int mid,int p){
        int count=0;
        int i=0;
        while(i<nums.length-1){
            if(nums[i+1]-nums[i]<=mid){
                count++;
                i=i+2;
            }
            else{
                i++;
            }
        }
        if(count>=p){
            return true;
        }
        else{
            return false;
        }
    }
}