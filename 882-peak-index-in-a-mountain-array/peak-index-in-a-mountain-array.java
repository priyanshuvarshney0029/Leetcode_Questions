class Solution {
    public int peakIndexInMountainArray(int[] arr) {
         int low=0;
         int high=arr.length-1;
         int ans=0;

         while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid] > arr[mid+1]){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
         }
         return ans;
    }
}