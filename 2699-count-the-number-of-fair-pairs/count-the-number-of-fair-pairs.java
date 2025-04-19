class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n=nums.length;
        Arrays.sort(nums);
        long ans=0;
        for(int i=0;i<n;i++){
            int left_idx=Lower_bound(nums,i+1,n-1,lower-nums[i]);
            int right_idx=Upper_bound(nums,i+1,n-1,upper-nums[i]);
    // x is.....
            int x=left_idx-1-i;
            int y=right_idx-1-i;

            ans+=(y-x);
        }
        return ans;
    }
    // lower bound=smallest indx such that arr[idx]>=tar
    public int Lower_bound(int nums[],int low,int high,int tar){
        int ans=nums.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>=tar){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    // upper bound=smallest indx sunch arr[idx]>target
     public int Upper_bound(int nums[],int low,int high,int tar){
        int ans=nums.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>tar){
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