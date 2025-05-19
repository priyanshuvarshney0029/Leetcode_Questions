class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1){
            if(nums[0]==target){
                return 0;
            }
            else{
                return -1;
            }
        }
       int idx = -1;
        for(int i = 1; i < nums.length ; i++){
            if(nums[i - 1] > nums[i]){
                idx = i;
                break;
            }
        }

        if(idx == -1) idx = 0; // ✅ FIX: array is not rotated
         int fir=bs(nums,0,idx-1,target);
         int sec=bs(nums,idx,nums.length-1,target);

         if(fir==-1 && sec==-1){
            return -1;
         }
         else if(fir!=-1){
            return fir;
         }
         else{
            return sec;
         }
        //  return -1;

    }
    public static int bs(int nums[],int low,int high,int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
               low=mid+1;
            }
        }
        return -1;
        
    }
}